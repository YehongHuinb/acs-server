package com.sw.acs.exception;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.sw.acs.web.domain.AjaxResult;
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

    @ExceptionHandler(JWTDecodeException.class)
    public AjaxResult handleJwtDecodeException(JWTDecodeException e){
        return AjaxResult.error(502,"token非法");
    }
}
