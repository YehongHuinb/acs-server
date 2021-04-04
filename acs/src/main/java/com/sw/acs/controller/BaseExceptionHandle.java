package com.sw.acs.controller;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 统一异常处理
 *
 * @author 周良聪
 */
@ControllerAdvice
public class BaseExceptionHandle {
    @ExceptionHandler(value = AuthorizationException.class)
    public String noPermission(HttpServletRequest request, HttpServletResponse response,AuthorizationException authorizationException){
        return "";
    }

}
