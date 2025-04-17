package org.light.server.dto;

import org.light.server.entity.Credit;
import org.light.server.entity.SysUser;

/**
 * 传输对象 - 信用分
 */
public class CreditDto {
    /**
     * 用户ID
     */
    private String userId;

    /**
     * 用户选择展示的名称
     */
    private String nickName;

    /**
     * 信用分
     */
    private Integer score;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
