package org.light.server.service;

import cn.dev33.satoken.stp.StpUtil;
import org.light.server.dto.AuditRecordDto;
import org.light.server.dto.ReportRecordDto;
import org.light.server.entity.AuditRecord;
import org.light.server.entity.ReportRecord;
import org.light.server.enums.ReportStatusEnum;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * 举报表 和 审查表 已经分开
 * 目前仅进行单人审查, 且没有超时/撤销流程
 */
@Service
public class AuditService {
    /**
     * 用户发起一次审查, 并设置审查人为自己
     * 此处已经预留了位置, 发起审查可以创建多个待审查记录,从而进行多人监管
     */
    @Transactional
    public boolean startAudit(ReportRecordDto reportRecordDto) {
        ReportRecord reportRecord = ReportRecord.create().setId(reportRecordDto.getId()).oneById();
        if(reportRecord == null || !ReportStatusEnum.已举报.type().equals(reportRecord.getReportStatus())) {
            return false;
        }
        if(ReportRecord.create().setId(reportRecord.getId()).setReportStatus(ReportStatusEnum.处理中.type())
                .updateById()){
            //增加审查记录
            if(!AuditRecord.create()
                    .setAuditStatus(ReportStatusEnum.处理中.type())
                    .setAuditTime(LocalDateTime.now())
                    .setReportId(reportRecord.getId())
                    .setGameId(reportRecord.getGameId())
                    .setAuditUserId(StpUtil.getLoginIdAsLong())
                    .save()){
                //回滚数据
                throw new RuntimeException("开始审查失败,请刷新后重试");
            }
        }
        return false;
    }

    /**
     * 用户提交一次审查结果
     * 如果是多人审查则检查同一个report_id的审查是否已经全部完成
     * todo 未作弊, 举报用户 信用分
     * todo 多人审查, 审查不一致 信用分
     */
    @Transactional
    public boolean verify(AuditRecordDto auditRecordDto) {
        AuditRecord audit = AuditRecord.create().setId(auditRecordDto.getId()).oneById();
        //已有结果
        if(audit.getVerifyStatus() != null){
            return false;
        }
        //未在待处理状态
        if(!ReportStatusEnum.处理中.type().equals(audit.getAuditStatus())){
            return false;
        }

        boolean updAudit = AuditRecord.create().setId(audit.getId())
                .setVerifyStatus(
                        auditRecordDto.getVerifyStatus()
                ).setVerifyUserId(
                        StpUtil.getLoginIdAsLong()
                ).setVerifyTime(
                        LocalDateTime.now()
                ).updateById();
        if(!updAudit){
            return false;
        }
        boolean updReport = ReportRecord.create()
                .setId(audit.getReportId())
                .setVerifyStatus(auditRecordDto.getVerifyStatus())
                .setReportStatus(ReportStatusEnum.已处理.type())
                .updateById()
                ;
        if(updReport){
           return true;
        }
        throw new RuntimeException("审查失败,请刷新后重试");
    }

}
