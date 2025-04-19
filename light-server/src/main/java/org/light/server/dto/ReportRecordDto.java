package org.light.server.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.light.server.enums.ReportStatusEnum;
import org.light.server.enums.VerifyStatusEnum;

/**
 * 传输对象 - 举报记录
 */
public class ReportRecordDto {
    /**
     * 标识符
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    /**
     * 举报名称
     */
    private String name;

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
     * 举报时间 yyyy-MM-dd HH:mm:ss
     */
    private String reportTime;

    /**
     * 举报链接
     */
    private String reportUrl;

    /**
     * 举报说明
     */
    private String reportRemark;

    /**
     * 举报用户Id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long reportUserId;


    private Integer reportStatus;
    /**
     * 举报状态 ReportStatusEnum
     */
    private String reportStatusNm;

    private Integer verifyStatus;
    /**
     * 核实结果 作弊 未作弊 无法核实
     */
    private String verifyStatusNm;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getReportTime() {
        return reportTime;
    }

    public void setReportTime(String reportTime) {
        this.reportTime = reportTime;
    }

    public String getReportUrl() {
        return reportUrl;
    }

    public void setReportUrl(String reportUrl) {
        this.reportUrl = reportUrl;
    }

    public String getReportRemark() {
        return reportRemark;
    }

    public void setReportRemark(String reportRemark) {
        this.reportRemark = reportRemark;
    }

    public Long getReportUserId() {
        return reportUserId;
    }

    public Integer getReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(Integer reportStatus) {
        this.reportStatus = reportStatus;
        this.reportStatusNm = ReportStatusEnum.format(reportStatus);
    }

    public void setReportUserId(Long reportUserId) {
        this.reportUserId = reportUserId;
    }

    public String getReportStatusNm() {
        return reportStatusNm;
    }

    public void setReportStatusNm(String reportStatusNm) {
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
}
