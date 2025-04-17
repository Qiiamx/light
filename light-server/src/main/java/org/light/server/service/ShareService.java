package org.light.server.service;

import org.light.server.enums.UserTypeEnum;
import org.springframework.stereotype.Service;

@Service
public class ShareService {
    /**
     * todo 获取被邀请人的权限
     * 如果是空, 返回默认角色
     * 如果已经使用 / 已经过期 则报错
     * @param shareId 邀请ID
     * @return UserTypeEnum
     */
    public UserTypeEnum getCreateUserType(Long shareId) {
        return UserTypeEnum.用户;
    }
}
