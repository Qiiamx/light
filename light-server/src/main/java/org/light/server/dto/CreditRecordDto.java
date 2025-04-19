package org.light.server.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 传输对象 - 信用记录
 */
public class CreditRecordDto {
    /**
     * 记录ID
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long Id;
    /**
     * 用户ID
     */
    private String userId;

    /**
     * 信用分(加减)
     */
    private Integer score;

    /**
     * 说明
     */
    private String rmks;

    private String createTime;

    public String getRmks() {
        return rmks;
    }

    public void setRmks(String rmks) {
        this.rmks = rmks;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
