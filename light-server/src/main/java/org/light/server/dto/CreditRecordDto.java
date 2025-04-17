package org.light.server.dto;

/**
 * 传输对象 - 信用记录
 */
public class CreditRecordDto {
    /**
     * 记录ID
     */
    private String Id;
    /**
     * 用户ID
     */
    private String userId;

    /**
     * 信用分(加减)
     */
    private Integer score;

    private String createTime;

    /**
     * 备注
     */
    private String rmks;

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

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
