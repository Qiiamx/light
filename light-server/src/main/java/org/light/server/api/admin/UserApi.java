package org.light.server.api.admin;

import org.light.server.common.Result;
import org.light.server.dto.ShareDto;
import org.light.server.dto.UserDto;

/**
 * 用户接口
 */
public interface UserApi {

    /**
     * 发起一个邀请
     */
    Result<ShareDto> share(ShareDto share);


    /**
     * 禁用用户
     */
    Result<UserDto> disable(String userId);

    /**
     * 启用用户
     */
    Result<UserDto> enable(String userId);

    /**
     * 修改用户角色
     */
    Result<UserDto> updateType(UserDto user);
}
