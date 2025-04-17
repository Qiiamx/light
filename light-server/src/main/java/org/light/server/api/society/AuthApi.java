package org.light.server.api.society;

import org.light.server.common.Result;
import org.light.server.dto.UserDto;

public interface AuthApi {

    /**
     * 第三方授权登录
     * @param code 第三方校验码
     * @param type 第三方类型
     * @param shareId 邀请ID用于设置权限,没有是普通用户
     */
    Result<UserDto> ossLogin(String code, String type, Long shareId);
}
