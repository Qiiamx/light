package org.light.server.controller.society;

import cn.dev33.satoken.stp.StpUtil;
import jakarta.annotation.Resource;
import org.light.server.api.society.AuthApi;
import org.light.server.common.Result;
import org.light.server.constant.ConstantValue;
import org.light.server.dto.ShareDto;
import org.light.server.dto.UserDto;
import org.light.server.entity.SysUser;
import org.light.server.enums.UserEnableEnum;
import org.light.server.enums.UserTypeEnum;
import org.light.server.service.AuthService;
import org.light.server.service.ShareService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("society/auth")
public class AuthController implements AuthApi {

    @Resource
    private AuthService authService;
    @Resource
    private ShareService shareService;

    @PostMapping("thirdLogin")
    @Override
    public Result<UserDto> thirdLogin(String code, String type) {
        String thirdId = authService.getThirdId(code, type);
        SysUser data = SysUser.create().setThirdId(thirdId).setThirdType(type).one();
        if(data == null){
            data = SysUser.create()
                    .setNickName("新用户")
                    .setEnable(UserEnableEnum.启用.type())
                    .setUserType(UserTypeEnum.用户.type())
                    .setThirdId(authService.getThirdId(code, type))
                    .setThirdType(type);
            data.save();
        }else{
            if(UserEnableEnum.禁用.type().equals(data.getEnable())){
                return Result.error("该用户已被禁用");
            }
        }
        //登录
        StpUtil.login(data.getId());
        //记录类型 UserTypeEnum
        StpUtil.getSession().set(ConstantValue.CACHE_SA_USER_ROLE, data.getUserType());
        return Result.success(new UserDto(data));
    }

    @PostMapping("updateUserTypeByShare")
    @Override
    public Result<UserDto> updateUserTypeByShare(ShareDto share) {
        if(!StringUtils.hasText(share.getId())){
            return Result.error("非法请求");
        }
        if(shareService.setUserType(Long.parseLong(share.getId()))){
            return Result.success();
        }else{
            return Result.error("邀请链接失效");
        }
    }


}
