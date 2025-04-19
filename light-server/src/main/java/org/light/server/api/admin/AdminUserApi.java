package org.light.server.api.admin;

import org.light.server.common.Result;
import org.light.server.dto.ShareDto;
import org.light.server.dto.UserDto;

/**
 * 用户接口
 */
public interface AdminUserApi {

    /**
     * 发起一个邀请
     */
    Result<ShareDto> share(ShareDto share);


    /**
     * 禁用用户
     */
    Result<UserDto> disable(UserDto user);

    /**
     * 启用用户
     */
    Result<UserDto> enable(UserDto user);

    /**
     * 修改用户角色
     */
    Result<UserDto> updateType(UserDto user);
}
