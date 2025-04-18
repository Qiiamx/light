package org.light.server.controller.admin;

import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.annotation.SaMode;
import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.temp.SaTempUtil;
import org.light.server.api.admin.UserApi;
import org.light.server.common.Result;
import org.light.server.constant.ConstantValue;
import org.light.server.dto.ShareDto;
import org.light.server.dto.UserDto;
import org.light.server.entity.SysUser;
import org.light.server.enums.UserEnableEnum;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/user")
@SaCheckRole(mode = SaMode.OR, value = {"1"})
public class UserController implements UserApi {

    /**
     * 返回一个邀请信息，由前端组成可复制的文本
     * 如果访问者已登录，设置为邀请的权限
     * 如果未登录，则先登录为普通用户，再设为邀请的权限
     */
    @PostMapping("share")
    @Override
    public Result<ShareDto> share(@RequestBody ShareDto share) {
        // todo 记录邀请到数据库
        return Result.success(share);
    }

    /**
     * 禁用用户
     * 自动踢下线
     */
    @PostMapping("disable")
    @Override
    public Result<UserDto> disable(@RequestBody UserDto user) {
        if(!StringUtils.hasText(user.getId())){
            return Result.error("非法请求");
        }
        Long uid = Long.parseLong(user.getId());
        SysUser data = SysUser.create().setId(uid).oneById();
        if(data == null){
            return Result.error("非法请求");
        }else{
            SysUser.create().setId(uid)
                    .setEnable(UserEnableEnum.禁用.type())
                    .updateById();
            if(StpUtil.isLogin(uid)) {
                StpUtil.logout(uid);
            }
        }
        return Result.success();
    }


    /**
     * 启用用户
     */
    @PostMapping("enable")
    @Override
    public Result<UserDto> enable(@RequestBody UserDto user) {
        if(!StringUtils.hasText(user.getId())){
            return Result.error("非法请求");
        }
        Long uid = Long.parseLong(user.getId());
        SysUser data = SysUser.create().setId(uid).oneById();
        if(data == null){
            return Result.error("非法请求");
        }else{
            SysUser.create().setId(uid)
                    .setEnable(UserEnableEnum.启用.type())
                    .updateById();
        }
        return Result.success();
    }


    /**
     * 更新用户角色
     * 无需重新登录
     */
    @PostMapping("updateType")
    @Override
    public Result<UserDto> updateType(@RequestBody UserDto user) {
        if(!StringUtils.hasText(user.getId())){
            return Result.error("非法请求");
        }
        Long uid = Long.parseLong(user.getId());
        SysUser data = SysUser.create().setId(uid).oneById();
        if(data == null){
            return Result.error("非法请求");
        }else{
            SysUser.create().setId(uid)
                    .setUserType(user.getUserType())
                    .updateById();
            if(StpUtil.isLogin(uid)) {
                SaSession session = StpUtil.getSessionByLoginId(uid);
                session.set(ConstantValue.CACHE_SA_USER_ROLE, user.getUserType());
            }
        }
        return Result.success();
    }

}
