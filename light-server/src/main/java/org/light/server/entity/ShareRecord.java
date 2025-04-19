package org.light.server.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import com.mybatisflex.core.activerecord.Model;

import java.io.Serial;
import java.time.LocalDateTime;


/**
 * 邀请记录表 实体类。
 *
 * @author 63443
 * @since 2025-04-19
 */
@Table("share_record")
public class ShareRecord extends Model<ShareRecord> {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    private Long shareId;

    private Long useUserId;

    private LocalDateTime useTime;

    public static ShareRecord create() {
        return new ShareRecord();
    }

    public Long getId() {
        return id;
    }

    public ShareRecord setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getShareId() {
        return shareId;
    }

    public ShareRecord setShareId(Long shareId) {
        this.shareId = shareId;
        return this;
    }

    public Long getUseUserId() {
        return useUserId;
    }

    public ShareRecord setUseUserId(Long useUserId) {
        this.useUserId = useUserId;
        return this;
    }

    public LocalDateTime getUseTime() {
        return useTime;
    }

    public ShareRecord setUseTime(LocalDateTime useTime) {
        this.useTime = useTime;
        return this;
    }

}
