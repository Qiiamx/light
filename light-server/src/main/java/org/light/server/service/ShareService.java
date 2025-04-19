package org.light.server.service;

import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.StpUtil;
import org.light.server.constant.ConstantValue;
import org.light.server.dto.ShareDto;
import org.light.server.entity.Share;
import org.light.server.entity.ShareRecord;
import org.light.server.entity.SysUser;
import org.light.server.enums.ValidTypeEnum;
import org.light.server.util.TimeUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ShareService {
    //todo 替换成redsi
    private final ConcurrentHashMap<Long, String> locks = new ConcurrentHashMap<>();

    /**
     * 设置邀请权限
     * @param shareId 邀请ID
     */
    @Transactional
    public boolean setUserType(Long shareId) {
        //获取邀请锁
        this.getShareLock(shareId);
        try{
            return this.setUserTypeReal(shareId);
        }finally {
            //释放邀请锁
            this.releaseShareLock(shareId);
        }
    }

    /**
     * 间隔1秒尝试获取锁,成功继续,失败抛错
     * @param shareId
     */
    private void getShareLock(Long shareId) {
        try {
            int tryCount = 0;
            while (tryCount < 5) {
                if (locks.putIfAbsent(shareId, "lock") == null) {
                    return;
                } else {
                    tryCount = tryCount + 1;
                }
                Thread.sleep(1000);
            }
        }catch (Exception e){
            throw new RuntimeException("网络繁忙请稍后再试");
        }
        throw new RuntimeException("网络繁忙请稍后再试");
    }

    /**
     * 删除锁
     * @param shareId
     */
    private void releaseShareLock(Long shareId) {
        locks.remove(shareId);
    }

    private boolean setUserTypeReal(Long shareId){

        //查询分享信息
        Share share = Share.create().setId(shareId).oneById();
        //判断是否有效
        if(share.getValidType().equals(ValidTypeEnum.无效.type())){
            return false;
        }
        //判断是否过期
        if(share.getValidTime().isBefore(LocalDateTime.now())){
            share.setValidType(ValidTypeEnum.无效.type());
            share.updateById();
            return false;
        }
        //存储使用记录
        //这里的数据库有唯一键
        try {
            boolean success = ShareRecord.create()
                    .setShareId(shareId)
                    .setUseUserId(StpUtil.getLoginIdAsLong())
                    .setUseTime(LocalDateTime.now())
                    .save();
            if(!success){
                return false;
            }
        }catch (Exception e){
            //任何错误,视为不成功
            return false;
        }
        //更新剩余次数
        share.setValidCount(share.getValidType() - 1);
        if(share.getValidCount() <= 0){
            share.setValidType(ValidTypeEnum.无效.type());
        }
        share.updateById();

        //更新用户权限
        Integer type = share.getShareType();
        SysUser.create().setId(StpUtil.getLoginIdAsLong()).setUserType(type).updateById();
        SaSession session = StpUtil.getSession();
        session.set(ConstantValue.CACHE_SA_USER_ROLE, type);

        return true;
    }

    public Share createShare(ShareDto share) {
        return Share.create()
                .setShareType(share.getShareType())
                .setShareUserId(StpUtil.getLoginIdAsLong())
                .setValidTime(TimeUtil.parseDate(share.getValidTime()))
                .setValidCount(share.getValidCount())
                .setValidType(ValidTypeEnum.有效.type())
                .saveOpt().orElse(null);
    }
}
