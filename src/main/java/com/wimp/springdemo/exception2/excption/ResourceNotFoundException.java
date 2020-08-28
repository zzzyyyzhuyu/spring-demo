package com.wimp.springdemo.exception2.excption;

import com.wimp.springdemo.exception2.BaseException;
import com.wimp.springdemo.exception2.ErrorCode;

import java.util.Map;

/**
 * @author zy
 * @date 2020/8/27
 * <p>
 *  自定义异常类:未找到资源
 */
public class ResourceNotFoundException extends BaseException {

    public ResourceNotFoundException(Map<String, Object> data) {
        super(ErrorCode.RESOURCE_NOT_FOUND, data);
    }
}
