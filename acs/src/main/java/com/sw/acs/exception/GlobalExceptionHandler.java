package com.sw.acs.exception;

import com.sw.acs.domain.AjaxResult;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author 周良聪
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(IncorrectCredentialsException.class)
    public AjaxResult handleIncorrectCredentialsException(IncorrectCredentialsException e){
        return AjaxResult.error(500,"密码错误！");
    }
}