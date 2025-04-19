package org.light.server.controller.society;

import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.annotation.SaMode;
import cn.dev33.satoken.stp.StpUtil;
import com.mybatisflex.core.paginate.Page;
import org.light.server.api.society.SocietyReportApi;
import org.light.server.common.Result;
import org.light.server.dto.ReportRecordDto;
import org.light.server.entity.Game;
import org.light.server.entity.ReportRecord;
import org.light.server.entity.table.GameTableDef;
import org.light.server.entity.table.ReportRecordTableDef;
import org.light.server.enums.ReportStatusEnum;
import org.light.server.service.ReportService;
import org.light.server.util.TimeUtil;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/society/report")
@SaCheckRole(mode = SaMode.OR, value = {"1","2","3"})
public class SocietyReportController implements SocietyReportApi {

    private final ReportService reportService;

    public SocietyReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("listMyReport")
    @Override
    public Result<Page<ReportRecordDto>> listMyReport(Integer pageNumber, Integer pageSize, ReportRecordDto report) {
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
                                .and(
                                        ReportRecordTableDef.REPORT_RECORD.REPORT_USER_ID.eq(StpUtil.getLoginIdAsLong())
                                )
                )
                .pageAs(
                        res, ReportRecordDto.class
                );
        return Result.success(res);
    }

    //todo 限流/限人/校验文件URL
    @PostMapping("submitReport")
    @Override
    public Result<ReportRecordDto> submitReport(ReportRecordDto reportRecord) {
        if(reportRecord.getGameId() == null){
            return Result.error("请选择游戏分类");
        }
        if(!StringUtils.hasText(reportRecord.getName())){
            return Result.error("请填写举报标题");
        }
        if(!StringUtils.hasText(reportRecord.getReportRemark())){
            return Result.error("请填写举报说明");
        }
        if(!StringUtils.hasText(reportRecord.getReportUrl())){
            return Result.error("请上传举报附件");
        }
        ReportRecord.create()
                .setGameId(reportRecord.getGameId())
                .setName(reportRecord.getName())
                .setReportUrl(reportRecord.getReportUrl())
                .setReportUserId(StpUtil.getLoginIdAsLong())
                .setReportRemark(reportRecord.getReportRemark())
                .setReportTime(LocalDateTime.now())
                .setReportStatus(ReportStatusEnum.已举报.type())
                .save();
        return Result.success();
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

    @Override
    public Result<ReportRecordDto> upload(MultipartFile file) {
        //todo 上传文件...emmmm
        return null;
    }

}
