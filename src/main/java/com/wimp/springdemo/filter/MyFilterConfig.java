package com.wimp.springdemo.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @author zy
 * @date 2020/8/31
 * <p>
 *  
 */
@Configuration
public class MyFilterConfig {

    @Resource
    private MyFilter myFilter;

    @Resource
    private MyFilter2 myFilter2;

    @Bean
    public FilterRegistrationBean<MyFilter> thirdFilter() {

        FilterRegistrationBean<MyFilter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setName("myFilter");
        filterFilterRegistrationBean.setFilter(myFilter);
        filterFilterRegistrationBean.setOrder(1);
        filterFilterRegistrationBean.setUrlPatterns(new ArrayDeque<>(Arrays.asList("/filterApi/*")));
        return filterFilterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean<MyFilter2> thirdFilter2() {

        FilterRegistrationBean<MyFilter2> filterFilterRegistrationBean2 = new FilterRegistrationBean<>();
        filterFilterRegistrationBean2.setName("myFIlter2");
        filterFilterRegistrationBean2.setFilter(myFilter2);
        filterFilterRegistrationBean2.setOrder(2);
        filterFilterRegistrationBean2.setUrlPatterns(new ArrayDeque<>(Arrays.asList("/filterApi/*")));
        return filterFilterRegistrationBean2;
    }
}
