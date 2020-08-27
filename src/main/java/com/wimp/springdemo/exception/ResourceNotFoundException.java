package com.wimp.springdemo.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author zy
 * @date 2020/8/27
 * <p>
 *  自定义资源未找到异常
 */
@Getter
@Setter
@ToString
public class ResourceNotFoundException extends RuntimeException {
    private String message;

    public ResourceNotFoundException(String message) {
        super(message);
        this.message = message;
    }

    public ResourceNotFoundException(String message, String message1) {
        super(message);
        this.message = message1;
    }

    public ResourceNotFoundException() {

    }
}
