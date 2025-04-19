package org.light.server.service;

import cn.dev33.satoken.stp.StpUtil;
import org.light.server.dto.ReportRecordDto;
import org.light.server.entity.AuditRecord;
import org.light.server.entity.ReportRecord;
import org.light.server.entity.table.AuditRecordTableDef;
import org.light.server.enums.ReportStatusEnum;
import org.light.server.enums.VerifyStatusEnum;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 举报表 和 审查表 已经分开
 * 目前仅进行单人审查, 且没有超时/撤销流程
 */
@Service
public class ReportService {
    /**
     * 用户取消一次举报
     * todo 联动信用分?
     * @param reportRecordDto
     * @return
     */
    @Transactional
    public boolean cancel(ReportRecordDto reportRecordDto) {
        ReportRecord report = ReportRecord.create().setId(reportRecordDto.getId()).oneById();
        if(report == null || report.getReportStatus().equals(ReportStatusEnum.取消.type())){
            return false;
        }
        //角色3(用户)只能取消自己创建的数据
        if(StpUtil.getRoleList().contains("3")) {
            if (!report.getReportUserId().equals(StpUtil.getLoginIdAsLong())) {
                throw new RuntimeException("无权限操作的数据");
            }
        }
        if(report.getReportStatus().equals(ReportStatusEnum.处理中.type())){
            //不再继续进行审核
            AuditRecord.create()
                    .setVerifyStatus(VerifyStatusEnum.取消.type())
                    .where(AuditRecordTableDef.AUDIT_RECORD.REPORT_ID.eq(report.getId()))
                    .update();
        }
        boolean updReport = ReportRecord.create().setId(report.getId())
                .setReportStatus(ReportStatusEnum.取消.type())
                .updateById();
        if(updReport){
            return true;
        }
        throw new RuntimeException("取消失败,请刷新后重试");
    }
}
