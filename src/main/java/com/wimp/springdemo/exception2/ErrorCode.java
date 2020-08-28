package com.wimp.springdemo.exception2;

import org.springframework.http.HttpStatus;

/**
 * @author zy
 * @date 2020/8/27
 * <p>
 *  异常信息编码
 */

public enum ErrorCode {
    /**
     * 未找到资源
     */
    RESOURCE_NOT_FOUND(1001, HttpStatus.NOT_FOUND, "未找到该资源"),
    /**
     * 请求数据格式校验失败
     */
    REQUEST_VALIDATION_FAILED(1002, HttpStatus.BAD_REQUEST, "请求数据格式验证失败");

    private final int code;

    private final HttpStatus httpStatus;

    private final String message;

    ErrorCode(int code, HttpStatus httpStatus, String message) {
        this.code = code;
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ErrorCode{" +
                "code=" + code +
                ", httpStatus=" + httpStatus +
                ", message='" + message + '\'' +
                '}';
    }
}
