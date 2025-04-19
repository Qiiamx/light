package org.light.server.controller.audit;

import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.annotation.SaMode;
import cn.dev33.satoken.stp.StpUtil;
import com.mybatisflex.core.paginate.Page;
import jakarta.annotation.Resource;
import org.light.server.api.audit.AuditReportApi;
import org.light.server.common.Result;
import org.light.server.dto.AuditRecordDto;
import org.light.server.dto.ReportRecordDto;
import org.light.server.entity.AuditRecord;
import org.light.server.entity.Game;
import org.light.server.entity.ReportRecord;
import org.light.server.entity.table.AuditRecordTableDef;
import org.light.server.entity.table.GameTableDef;
import org.light.server.entity.table.ReportRecordTableDef;
import org.light.server.service.AuditService;
import org.light.server.service.ReportService;
import org.light.server.util.TimeUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/audit/report")
@SaCheckRole(mode = SaMode.OR, value = {"1","2"})
public class AuditReportController implements AuditReportApi {

    @Resource
    private ReportService reportService;
    @Resource
    private AuditService auditService;

    @GetMapping("listReport")
    @Override
    public Result<Page<ReportRecordDto>> listReport(Integer pageNumber, Integer pageSize, ReportRecordDto report) {
        Page<ReportRecordDto> res = new Page<>(pageNumber, pageSize);
                ReportRecord.create()
                    .select(
                                ReportRecordTableDef.REPORT_RECORD.ID,
                                ReportRecordTableDef.REPORT_RECORD.NAME,
                                ReportRecordTableDef.REPORT_RECORD.GAME_ID,
                                ReportRecordTableDef.REPORT_RECORD.REPORT_URL,
                                ReportRecordTableDef.REPORT_RECORD.REPORT_TIME,
                                ReportRecordTableDef.REPORT_RECORD.REPORT_STATUS,
                                ReportRecordTableDef.REPORT_RECORD.VERIFY_STATUS,
                                ReportRecordTableDef.REPORT_RECORD.ID,
                                GameTableDef.GAME.NAME.as("game_name")
                            )
                        .leftJoin(Game.class).on(GameTableDef.GAME.ID.eq(ReportRecordTableDef.REPORT_RECORD.GAME_ID))
                        .where(
                                GameTableDef.GAME.ID.eq(report.getGameId(), report.getGameId()!=null)
                                .and(
                                        ReportRecordTableDef.REPORT_RECORD.REPORT_TIME.between(TimeUtil.between(report.getReportTime()), report.getReportTime()!=null)
                                )
                                .and(
                                        ReportRecordTableDef.REPORT_RECORD.REPORT_STATUS.eq(report.getReportStatus(), report.getReportStatus() != null)
                                )
                                .and(
                                        ReportRecordTableDef.REPORT_RECORD.VERIFY_STATUS.eq(report.getVerifyStatus(), report.getVerifyStatus() != null)
                                )
                        )
                    .pageAs(
                            res, ReportRecordDto.class
                    );
        return Result.success(res);
    }

    @GetMapping("startAudit")
    @Override
    public Result<ReportRecordDto> startAudit(ReportRecordDto report) {
        if(auditService.startAudit(report)){
            return Result.success();
        }else{
            return Result.error("开始审查失败,请刷新后重试");
        }
    }

    @PostMapping("cancelReport")
    @Override
    public Result<ReportRecordDto> cancelReport(ReportRecordDto reportRecord) {
        if(reportService.cancel(reportRecord)){
            return Result.success();
        }else {
            return Result.error("取消失败,请刷新后重试");
        }
    }

    @PostMapping("listMyAudit")
    @Override
    public Result<Page<AuditRecordDto>> listMyAudit(Integer pageNumber, Integer pageSize, AuditRecordDto auditRecord) {
        Page<AuditRecordDto> res = new Page<>(pageNumber, pageSize);
        AuditRecord.create()
                .select(
                        AuditRecordTableDef.AUDIT_RECORD.ALL_COLUMNS,
                        ReportRecordTableDef.REPORT_RECORD.REPORT_REMARK,
                        ReportRecordTableDef.REPORT_RECORD.REPORT_URL
                )
                .leftJoin(ReportRecord.class).on(ReportRecordTableDef.REPORT_RECORD.ID.eq(AuditRecordTableDef.AUDIT_RECORD.REPORT_ID))
                .where(
                        AuditRecordTableDef.AUDIT_RECORD.AUDIT_USER_ID.eq(StpUtil.getLoginIdAsLong())
                                .and(
                                        AuditRecordTableDef.AUDIT_RECORD.GAME_ID.eq(auditRecord.getGameId(), auditRecord.getGameId()!=null)
                                )
                                .and(
                                        AuditRecordTableDef.AUDIT_RECORD.AUDIT_STATUS.eq(auditRecord.getAuditStatus(), auditRecord.getAuditStatus() != null)
                                )
                                .and(
                                        AuditRecordTableDef.AUDIT_RECORD.VERIFY_STATUS.eq(auditRecord.getVerifyStatus(), auditRecord.getVerifyStatus() != null)
                                )
                )
                .orderBy(AuditRecordTableDef.AUDIT_RECORD.AUDIT_TIME, false)
                .pageAs(
                        res, AuditRecordDto.class
                );
        return Result.success(res);
    }

    @PostMapping("verify")
    @Override
    public Result<AuditRecordDto> verify(AuditRecordDto auditRecord) {
        if(auditService.verify(auditRecord)){
            return Result.success();
        }else{
            return Result.error("审查失败,请刷新后重试");
        }
    }
}
