package org.light.server.controller.society;

import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.annotation.SaMode;
import cn.dev33.satoken.stp.StpUtil;
import com.mybatisflex.core.paginate.Page;
import org.light.server.api.society.CreditApi;
import org.light.server.common.QueryPage;
import org.light.server.common.Result;
import org.light.server.dto.CreditDto;
import org.light.server.dto.CreditRecordDto;
import org.light.server.entity.Credit;
import org.light.server.entity.CreditRecord;
import org.light.server.entity.SysUser;
import org.light.server.entity.table.CreditRecordTableDef;
import org.light.server.entity.table.CreditTableDef;
import org.light.server.entity.table.SysUserTableDef;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("society/credit")
@SaCheckRole(mode = SaMode.OR, value = {"1","2","3"})
public class CreditController implements CreditApi {

    @GetMapping("getMyCreditScore")
    @Override
    public Result<CreditDto> getMyCreditScore() {
        Long loginId = StpUtil.getLoginIdAsLong();
        CreditDto data = Credit.create()
                .select(CreditTableDef.CREDIT.SCORE.as("score"),
                        SysUserTableDef.SYS_USER.ID.as("userId"),
                        SysUserTableDef.SYS_USER.NICK_NAME.as("nickName")
                )
                .leftJoin(SysUser.class).on(
                        SysUserTableDef.SYS_USER.ID.eq(CreditTableDef.CREDIT.USER_ID)
                )
                .where(CreditTableDef.CREDIT.USER_ID.eq(loginId))
                .oneAs(CreditDto.class);
        return Result.success(data);
    }

    @GetMapping("listMyCreditRecord")
    @Override
    public Result<Page<CreditRecordDto>> listMyCreditRecord(QueryPage<CreditRecordDto> page) {
        Long loginId = StpUtil.getLoginIdAsLong();
        Page<CreditRecordDto> res = new Page<>(page.getPage(), page.getSize());
        CreditRecord.create()
                .select(CreditRecordTableDef.CREDIT_RECORD.ALL_COLUMNS)
                .where(CreditRecordTableDef.CREDIT_RECORD.USER_ID.eq(loginId))
                .pageAs(res, CreditRecordDto.class);
        return Result.success(res);
    }
}
