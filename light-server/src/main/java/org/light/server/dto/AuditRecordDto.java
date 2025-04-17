package org.light.server.dto;

/**
 * 传输对象 - 核实记录
 */
public class AuditRecordDto {
    /**
     * 标识符
     */
    private String id;

    /**
     * 游戏id
     */
    private String gameId;

    /**
     * 游戏名称
     */
    private String gameName;

    /**
     * 举报ID
     */
    private String reportId;

    /**
     * 核实用户ID
     */
    private String verifyUserId;

    /**
     * 核实结果
     */
    private String verifyStatus;

    /**
     * 核实结果-中文
     * 待核实 核实作弊 核实未作弊 无法确定
     * 拓展到多用户审查
     */
    private String verifyStatusNm;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public String getVerifyUserId() {
        return verifyUserId;
    }

    public void setVerifyUserId(String verifyUserId) {
        this.verifyUserId = verifyUserId;
    }

    public String getVerifyStatus() {
        return verifyStatus;
    }

    public void setVerifyStatus(String verifyStatus) {
        this.verifyStatus = verifyStatus;
    }

    public String getVerifyStatusNm() {
        return verifyStatusNm;
    }

    public void setVerifyStatusNm(String verifyStatusNm) {
        this.verifyStatusNm = verifyStatusNm;
    }
}
