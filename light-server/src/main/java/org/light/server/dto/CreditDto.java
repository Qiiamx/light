package org.light.server.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 传输对象 - 信用分
 */
public class CreditDto {
    /**
     * 用户ID
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long userId;

    /**
     * 用户选择展示的名称
     */
    private String nickName;

    /**
     * 信用分
     */
    private Integer score;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
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
