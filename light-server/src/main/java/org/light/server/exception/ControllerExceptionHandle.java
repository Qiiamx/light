package org.light.server.exception;

import cn.dev33.satoken.exception.SaTokenException;
import org.light.server.common.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandle {

    @ExceptionHandler(Exception.class)
    public Result exception(Exception e) {
        return Result.error("未知错误");
    }

    @ExceptionHandler(SaTokenException.class)
    public Result saTokenException(SaTokenException e) {
        return Result.error(e.getCode(), e.getMessage());
    }
}
