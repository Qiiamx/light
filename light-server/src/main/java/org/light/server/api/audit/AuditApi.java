package org.light.server.api.audit;

import com.mybatisflex.core.paginate.Page;
import org.light.server.common.QueryPage;
import org.light.server.common.Result;
import org.light.server.dto.AuditRecordDto;
import org.light.server.dto.ReportRecordDto;

/**
 * 审查接口
 */
public interface AuditApi {

    /**
     * 对指定举报记录发起一次审查
     */
    Result<ReportRecordDto> startVerify(ReportRecordDto report);


    /**
     * 查看我的待审查数据
     */
    Result<Page<AuditRecordDto>> listMyAudit(QueryPage<AuditRecordDto> report);

    /**
     * 提交审查结果
     * 无法核实进入多人审查流程
     */
    Result<AuditRecordDto> verify(AuditRecordDto report);
}
