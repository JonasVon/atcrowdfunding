package com.jonas.atcrowdfunding.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * 登录异常
 */
@ControllerAdvice
public class LoginException {

    @ExceptionHandler(CommonException.class)
    public String userNotFound(Exception e,HttpServletRequest request){
        request.setAttribute("error",e.getMessage());
        request.setAttribute("exception",e);
        request.setAttribute("loginacct",request.getParameter("loginacct"));
        return "login";
    }

}
