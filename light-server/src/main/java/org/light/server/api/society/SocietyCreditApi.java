package org.light.server.api.society;

import com.mybatisflex.core.paginate.Page;
import org.light.server.common.Result;
import org.light.server.dto.CreditDto;
import org.light.server.dto.CreditRecordDto;

/**
 * 信用查询接口
 */
public interface SocietyCreditApi {
    /**
     * 获取我的信用分
     */
    Result<CreditDto> getMyCreditScore();

    /**
     * 获取我的信用分变化记录
     */
    Result<Page<CreditRecordDto>> listMyCreditRecord(Integer pageNumber, Integer pageSize, CreditRecordDto creditRecord);
}
