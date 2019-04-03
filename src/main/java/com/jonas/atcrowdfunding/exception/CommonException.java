package com.jonas.atcrowdfunding.exception;

/**
 * 自定义异常类
 */
public class CommonException extends RuntimeException {
    private String error;

    public CommonException(){}

    public CommonException(String error){
        super(error);
        this.error = error;
    }
}
