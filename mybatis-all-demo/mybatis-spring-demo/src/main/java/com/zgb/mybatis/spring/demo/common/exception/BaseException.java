package com.zgb.mybatis.spring.demo.common.exception;

/**
 * @author xmly
 */
public class BaseException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * 构造函数
     */
    public BaseException() {
        super();
    }

    /**
     * 构造函数
     * 
     * @param message 异常信息
     */
    public BaseException(String message) {
        super(message);
    }

    /**
     * 构造函数
     * 
     * @param throwable 异常栈
     */
    public BaseException(Throwable throwable) {
        super(throwable);
    }

    /**
     * 构造函数
     * 
     * @param message 异常信息
     * @param throwable 异常栈
     */
    public BaseException(String message, Throwable throwable) {
        super(message, throwable);
    }
}