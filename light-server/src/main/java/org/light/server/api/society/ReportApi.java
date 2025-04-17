package org.light.server.api.society;

import com.mybatisflex.core.paginate.Page;
import org.light.server.common.QueryPage;
import org.light.server.common.Result;
import org.light.server.dto.ReportRecordDto;

/**
 * 公众举报接口
 */
public interface ReportApi {
    /**
     * 列出我上传的举报记录
     */
    Result<Page<ReportRecordDto>> listMyReport(QueryPage<ReportRecordDto> page);
}
