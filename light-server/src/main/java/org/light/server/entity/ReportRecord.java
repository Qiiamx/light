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
@Table("report_record")
public class ReportRecord extends Model<ReportRecord> {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    private String name;

    private Long gameId;

    private LocalDateTime reportTime;

    private String reportUrl;

    private String reportRemark;

    private Long reportUserId;

    private Integer reportStatus;

    private Integer verifyStatus;

    public static ReportRecord create() {
        return new ReportRecord();
    }

    public Long getId() {
        return id;
    }

    public ReportRecord setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ReportRecord setName(String name) {
        this.name = name;
        return this;
    }

    public Long getGameId() {
        return gameId;
    }

    public ReportRecord setGameId(Long gameId) {
        this.gameId = gameId;
        return this;
    }

    public LocalDateTime getReportTime() {
        return reportTime;
    }

    public ReportRecord setReportTime(LocalDateTime reportTime) {
        this.reportTime = reportTime;
        return this;
    }

    public String getReportUrl() {
        return reportUrl;
    }

    public ReportRecord setReportUrl(String reportUrl) {
        this.reportUrl = reportUrl;
        return this;
    }

    public String getReportRemark() {
        return reportRemark;
    }

    public ReportRecord setReportRemark(String reportRemark) {
        this.reportRemark = reportRemark;
        return this;
    }

    public Long getReportUserId() {
        return reportUserId;
    }

    public ReportRecord setReportUserId(Long reportUserId) {
        this.reportUserId = reportUserId;
        return this;
    }

    public Integer getReportStatus() {
        return reportStatus;
    }

    public ReportRecord setReportStatus(Integer reportStatus) {
        this.reportStatus = reportStatus;
        return this;
    }

    public Integer getVerifyStatus() {
        return verifyStatus;
    }

    public ReportRecord setVerifyStatus(Integer verifyStatus) {
        this.verifyStatus = verifyStatus;
        return this;
    }

}
