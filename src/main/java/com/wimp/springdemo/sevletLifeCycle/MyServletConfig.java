package com.wimp.springdemo.sevletLifeCycle;

import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author zy
 * @date 2020/8/25
 * <p>
 * @PostConstruct @PreDestroy
 * 方式初始化配置
 */
@Configuration
public class MyServletConfig {

    public MyServletConfig(){
        System.out.println("init myServletConfig");
    }

    /**
     * serlvet初始化之后执行，java9取消
     */
    @PostConstruct
    private void init(){
        System.out.println("after init myServletConfig");
    }

    /**
     * servlet销毁之前执行，java9之后取消
     */
    @PreDestroy
    private void shutDown(){
        System.out.println("before shutdown myServletConfig");
    }

}
