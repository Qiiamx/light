package org.light.server.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.light.server.entity.Share;
import org.light.server.enums.UserTypeEnum;
import org.light.server.enums.ValidTypeEnum;
import org.light.server.util.TimeUtil;

/**
 * 传输对象 - 邀请
 */
public class ShareDto {
    /**
     * 邀请Id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    /**
     * 是否有效
     */
    private Integer validType;
    private String validTypeNm;
    /**
     * 可使用的次数(邀请人数)
     */
    private Integer validCount;
    /**
     * 有效时间
     */
    private String validTime;
    /**
     * 邀请类型 - 用户/审核/管理员
     */
    private Integer shareType;

    private String shareTypeNm;
    /**
     * 文本
     */
    private String text;
    /**
     * 发起用户id
     */
    private String shareUserId;

    public ShareDto() {
    }
    public ShareDto(Share data) {
        this.setId(data.getId());
        this.setValidType(data.getValidType());
        this.setValidCount(data.getValidCount());
        this.setValidTime(TimeUtil.format(data.getValidTime()));
        this.setShareType(data.getShareType());
        this.setShareUserId(data.getShareUserId().toString());
        this.setText(
                "邀请您成为网站"+this.getShareTypeNm()+", 有效期: "+ this.getValidTime() +", 链接: host_from_agent/share/"+this.getId()
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getValidType() {
        return validType;
    }

    public void setValidType(Integer validType) {
        this.validType = validType;
        this.validTypeNm = ValidTypeEnum.format(validType);
    }

    public String getValidTypeNm() {
        return validTypeNm;
    }

    public void setValidTypeNm(String validTypeNm) {
    }

    public String getValidTime() {
        return validTime;
    }

    public void setValidTime(String validTime) {
        this.validTime = validTime;
    }

    public Integer getShareType() {
        return shareType;
    }

    public void setShareType(Integer shareType) {
        this.shareType = shareType;
        this.shareTypeNm = UserTypeEnum.format(shareType);
    }

    public String getShareTypeNm() {
        return shareTypeNm;
    }

    public void setShareTypeNm(String shareTypeNm) {

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

    public Integer getValidCount() {
        return validCount;
    }

    public void setValidCount(Integer validCount) {
        this.validCount = validCount;
    }
}
