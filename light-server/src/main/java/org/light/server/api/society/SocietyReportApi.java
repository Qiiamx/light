package org.light.server.api.society;

import com.mybatisflex.core.paginate.Page;
import org.light.server.common.Result;
import org.light.server.dto.ReportRecordDto;
import org.springframework.web.multipart.MultipartFile;

/**
 * 公众举报接口
 */
public interface SocietyReportApi {
    /**
     * 列出我上传的举报记录
     */
    Result<Page<ReportRecordDto>> listMyReport(Integer pageNumber, Integer pageSize, ReportRecordDto reportRecord);

    /**
     * 提交举报
     */
    Result<ReportRecordDto> submitReport(ReportRecordDto reportRecord);

    /**
     * 取消举报
     */
    Result<ReportRecordDto> cancelReport(ReportRecordDto reportRecord);

    /**
     * 上传附件
     */
    Result<ReportRecordDto> upload(MultipartFile file);
}
