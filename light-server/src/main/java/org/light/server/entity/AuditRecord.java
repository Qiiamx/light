package org.light.server.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import com.mybatisflex.core.activerecord.Model;

import java.io.Serial;
import java.time.LocalDateTime;


/**
 *  实体类。
 *
 * @author 63443
 * @since 2025-04-19
 */
@Table("audit_record_dto")
public class AuditRecord extends Model<AuditRecord> {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    private Long gameId;

    private Long reportId;

    private Long auditUserId;

    private Long verifyUserId;

    private Integer auditStatus;

    private Integer verifyStatus;

    private LocalDateTime auditTime;

    private LocalDateTime verifyTime;

    public static AuditRecord create() {
        return new AuditRecord();
    }

    public Long getId() {
        return id;
    }

    public AuditRecord setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getGameId() {
        return gameId;
    }

    public AuditRecord setGameId(Long gameId) {
        this.gameId = gameId;
        return this;
    }

    public Long getReportId() {
        return reportId;
    }

    public AuditRecord setReportId(Long reportId) {
        this.reportId = reportId;
        return this;
    }

    public Long getVerifyUserId() {
        return verifyUserId;
    }

    public AuditRecord setVerifyUserId(Long verifyUserId) {
        this.verifyUserId = verifyUserId;
        return this;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public AuditRecord setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
        return this;
    }

    public Integer getVerifyStatus() {
        return verifyStatus;
    }

    public AuditRecord setVerifyStatus(Integer verifyStatus) {
        this.verifyStatus = verifyStatus;
        return this;
    }

    public LocalDateTime getAuditTime() {
        return auditTime;
    }

    public AuditRecord setAuditTime(LocalDateTime auditTime) {
        this.auditTime = auditTime;
        return this;
    }

    public LocalDateTime getVerifyTime() {
        return verifyTime;
    }

    public AuditRecord setVerifyTime(LocalDateTime verifyTime) {
        this.verifyTime = verifyTime;
        return this;
    }

    public Long getAuditUserId() {
        return auditUserId;
    }

    public AuditRecord setAuditUserId(Long auditUserId) {
        this.auditUserId = auditUserId;
        return this;
    }
}
