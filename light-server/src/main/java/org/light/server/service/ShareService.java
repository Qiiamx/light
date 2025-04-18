package org.light.server.service;

import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.StpUtil;
import org.light.server.constant.ConstantValue;
import org.light.server.entity.SysUser;
import org.light.server.enums.UserTypeEnum;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ShareService {
    /**
     * 设置邀请权限
     * @param shareId 邀请ID
     */
    @Transactional
    public boolean setUserType(Long shareId) {
        //todo 获取分享信息，检验有效性
        Integer type = 3;
        SysUser.create().setId(StpUtil.getLoginIdAsLong()).setUserType(type).updateById();
        SaSession session = StpUtil.getSession();
        session.set(ConstantValue.CACHE_SA_USER_ROLE, type);
        //todo 更新有效性
        return true;
    }
}
