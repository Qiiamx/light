package org.light.server.controller.society;

import cn.dev33.satoken.annotation.SaIgnore;
import jakarta.annotation.Resource;
import org.light.server.api.society.AuthApi;
import org.light.server.common.Result;
import org.light.server.dto.UserDto;
import org.light.server.entity.SysUser;
import org.light.server.service.AuthService;
import org.light.server.service.ShareService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("society/auth")
@SaIgnore
public class AuthController implements AuthApi {

    @Resource
    private AuthService authService;
    @Resource
    private ShareService shareService;

    @GetMapping("ossLogin")
    @Override
    public Result<UserDto> ossLogin(String code, String type, Long shareId) {
        SysUser data = SysUser.create()
                .setNickName("新用户")
                .setEnable(1)
                .setUserType(shareService.getCreateUserType(shareId).type())
                .setThirdId(authService.getThirdId(code, type))
                .setThirdType(type);
        data.save();
        return Result.success(new UserDto(data));
    }
}
