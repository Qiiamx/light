package org.light.server.service;

import org.springframework.stereotype.Service;

@Service
public class AuthService {
    /**
     * todo 获取用户第三方唯一标识
     * @param code 第三方校验码
     * @param type 第三方类型
     * @return 第三方标识
     */
    public String getThirdId(String code, String type){
        return null;
    }
}
