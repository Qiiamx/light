package org.light.server.controller.admin;

import org.light.server.api.admin.UserApi;
import org.light.server.common.Result;
import org.light.server.dto.ShareDto;
import org.light.server.dto.UserDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/user")
public class UserController implements UserApi {

    @PostMapping("share")
    @Override
    public Result<ShareDto> share(@RequestBody ShareDto share) {
        return null;
    }

    @PostMapping("disable")
    @Override
    public Result<UserDto> disable(@RequestBody String userId) {
        return null;
    }

    @PostMapping("enable")
    @Override
    public Result<UserDto> enable(@RequestBody String userId) {
        return null;
    }

    @PostMapping("updateType")
    @Override
    public Result<UserDto> updateType(@RequestBody UserDto user) {
        return null;
    }

}
