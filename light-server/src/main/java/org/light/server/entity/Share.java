package org.light.server.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import com.mybatisflex.core.activerecord.Model;

import java.io.Serial;
import java.time.LocalDateTime;


/**
 * 邀请表 实体类。
 *
 * @author 63443
 * @since 2025-04-19
 */
@Table("share")
public class Share extends Model<Share> {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    private Integer validType;

    private LocalDateTime validTime;

    private Integer shareType;

    private Long shareUserId;

    private Integer validCount;

    public static Share create() {
        return new Share();
    }

    public Long getId() {
        return id;
    }

    public Share setId(Long id) {
        this.id = id;
        return this;
    }

    public Integer getValidType() {
        return validType;
    }

    public Share setValidType(Integer validType) {
        this.validType = validType;
        return this;
    }

    public LocalDateTime getValidTime() {
        return validTime;
    }

    public Share setValidTime(LocalDateTime validTime) {
        this.validTime = validTime;
        return this;
    }

    public Integer getShareType() {
        return shareType;
    }

    public Share setShareType(Integer shareType) {
        this.shareType = shareType;
        return this;
    }

    public Long getShareUserId() {
        return shareUserId;
    }

    public Share setShareUserId(Long shareUserId) {
        this.shareUserId = shareUserId;
        return this;
    }

    public Integer getValidCount() {
        return validCount;
    }

    public Share setValidCount(Integer validCount) {
        this.validCount = validCount;
        return this;
    }

}
