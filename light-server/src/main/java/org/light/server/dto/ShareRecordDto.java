package org.light.server.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 传输对象 - 邀请
 */
public class ShareRecordDto {
    /**
     * 邀请Id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    /**
     * 是否有效
     */
    private String shareId;
    private String useUserId;
    private String useTime;
    //todo 联查更多字段


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShareId() {
        return shareId;
    }

    public void setShareId(String shareId) {
        this.shareId = shareId;
    }

    public String getUseUserId() {
        return useUserId;
    }

    public void setUseUserId(String useUserId) {
        this.useUserId = useUserId;
    }

    public String getUseTime() {
        return useTime;
    }

    public void setUseTime(String useTime) {
        this.useTime = useTime;
    }
}
