package com.wimp.springdemo.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author zy
 * @date 2020/8/27
 * <p>
 *  异常信息包装
 */
@Getter
@Setter
@ToString
public class ErrorResponse {
    private String message;
    private String errorTypeName;

    public ErrorResponse(Exception e){
        this(e.getClass().getName(),e.getMessage());
    }

    public ErrorResponse(String errorTypeName,String message){
        this.errorTypeName = errorTypeName;
        this.message = message;
    }
}
