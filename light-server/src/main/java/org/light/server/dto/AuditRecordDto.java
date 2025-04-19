package org.light.server.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.light.server.enums.ReportStatusEnum;
import org.light.server.enums.VerifyStatusEnum;

/**
 * 传输对象 - 核实记录
 */
public class AuditRecordDto {
    /**
     * 标识符
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    /**
     * 游戏id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long gameId;

    /**
     * 游戏名称
     */
    private String gameName;

    /**
     * 举报ID
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long reportId;

    /**
     * 审查用户ID
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long auditUserId;
    /**
     * 核实用户ID
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long verifyUserId;

    /**
     * 审核状态
     */
    private Integer auditStatus;

    /**
     * 审核状态-中文
     * ReportStatusEnum
     */
    private String auditStatusNm;
    /**
     * 核实结果
     */
    private Integer verifyStatus;

    /**
     * 核实结果-中文
     * VerifyStatusEnum
     */
    private String verifyStatusNm;

    /**
     * 审查开始时间
     */
    private String auditTime;

    /**
     * 审查结束时间
     */
    private String verifyTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public Long getReportId() {
        return reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    public Long getAuditUserId() {
        return auditUserId;
    }

    public void setAuditUserId(Long auditUserId) {
        this.auditUserId = auditUserId;
    }

    public Long getVerifyUserId() {
        return verifyUserId;
    }

    public void setVerifyUserId(Long verifyUserId) {
        this.verifyUserId = verifyUserId;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
        this.auditStatusNm = ReportStatusEnum.format(auditStatus);
    }

    public String getAuditStatusNm() {
        return auditStatusNm;
    }

    public void setAuditStatusNm(String auditStatusNm) {
    }

    public Integer getVerifyStatus() {
        return verifyStatus;
    }

    public void setVerifyStatus(Integer verifyStatus) {
        this.verifyStatus = verifyStatus;
        this.verifyStatusNm = VerifyStatusEnum.format(verifyStatus);
    }

    public String getVerifyStatusNm() {
        return verifyStatusNm;
    }

    public void setVerifyStatusNm(String verifyStatusNm) {

    }

    public String getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(String auditTime) {
        this.auditTime = auditTime;
    }

    public String getVerifyTime() {
        return verifyTime;
    }

    public void setVerifyTime(String verifyTime) {
        this.verifyTime = verifyTime;
    }
}
