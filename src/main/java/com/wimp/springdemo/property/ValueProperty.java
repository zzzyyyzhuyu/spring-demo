package com.wimp.springdemo.property;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author zy
 * @date 2020/8/26
 * <p>
 * @Value方式取值
 */
public class ValueProperty {
    @Value("#{wuhan2020}")
    private String wuhan2020;
}
