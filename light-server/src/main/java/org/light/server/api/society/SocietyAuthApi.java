package org.light.server.api.society;

import org.light.server.common.Result;
import org.light.server.dto.ShareDto;
import org.light.server.dto.UserDto;

public interface SocietyAuthApi {

    /**
     * 第三方授权登录
     * @param code 第三方校验码
     * @param type 第三方类型
     */
    Result<UserDto> thirdLogin(String code, String type);


    /**
     * 通过邀请更新用户类型
     * @param share
     * @return
     */
    Result<UserDto> updateUserTypeByShare(ShareDto share);

    /**
     * 更新用户昵称
     * @param user
     * @return
     */
    Result<UserDto> updateUserNickName(UserDto user);
}
