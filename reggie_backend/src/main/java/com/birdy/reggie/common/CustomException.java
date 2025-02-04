package com.birdy.reggie.common;

/**
 * @author Birdy
 * @date 2025/2/4 15:03
 * @description CustomException 自定义业务异常
 */
public class CustomException extends RuntimeException {
    public CustomException(String message) {
        super(message);
    }
}
