package org.light.server.dto;

/**
 * 传输对象 - 举报记录
 */
public class ReportRecordDto {
    /**
     * 标识符
     */
    private String id;

    /**
     * 举报名称
     */
    private String name;

    /**
     * 游戏id
     */
    private String gameId;

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
    private String reportUserId;


    /**
     * 举报状态 已举报 处理中 已处理
     */
    private String reportStatusNm;

    /**
     * 核实结果 作弊 未作弊 无法核实
     */
    private String verifyStatusNm;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
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

    public String getReportUserId() {
        return reportUserId;
    }

    public void setReportUserId(String reportUserId) {
        this.reportUserId = reportUserId;
    }

    public String getReportStatusNm() {
        return reportStatusNm;
    }

    public void setReportStatusNm(String reportStatusNm) {
        this.reportStatusNm = reportStatusNm;
    }

    public String getVerifyStatusNm() {
        return verifyStatusNm;
    }

    public void setVerifyStatusNm(String verifyStatusNm) {
        this.verifyStatusNm = verifyStatusNm;
    }
}
