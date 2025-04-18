package org.light.server.dto;

/**
 * 传输对象 - 邀请
 */
public class ShareDto {
    /**
     * 邀请Id
     */
    private String id;
    /**
     * 有效时间
     */
    private String validTime;
    /**
     * 邀请类型 - 用户/审核/管理员
     */
    private String shareType;
    /**
     * 文本
     */
    private String text;
    /**
     * 发起用户id
     */
    private String shareUserId;
    /**
     * 最终使用的用户id，只能用一次
     */
    private String useUserId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValidTime() {
        return validTime;
    }

    public void setValidTime(String validTime) {
        this.validTime = validTime;
    }

    public String getShareType() {
        return shareType;
    }

    public void setShareType(String shareType) {
        this.shareType = shareType;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getShareUserId() {
        return shareUserId;
    }

    public void setShareUserId(String shareUserId) {
        this.shareUserId = shareUserId;
    }
}
