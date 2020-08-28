package com.wimp.springdemo.exception2;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zy
 * @date 2020/8/27
 * <p>
 *  基础异常类
 */
@Getter
@Setter
@ToString
public class BaseException extends RuntimeException {
    private  ErrorCode error;
    private  Map<String,Object> data = new HashMap<>();

    public BaseException(ErrorCode errorCode, Map<String,Object> data){
        super(errorCode.getMessage());
        this.error = errorCode;
        if(!ObjectUtils.isEmpty(data)){
            this.data = data;
        }
    }


}
