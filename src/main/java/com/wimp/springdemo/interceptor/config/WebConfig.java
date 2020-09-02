package com.wimp.springdemo.interceptor.config;

import com.wimp.springdemo.interceptor.AdminInterceptor;
import com.wimp.springdemo.interceptor.LoginInterceptor;
import com.wimp.springdemo.interceptor.OldLoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author zy
 * @date 2020/9/2
 * <p>
 *  
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns();
        registry.addInterceptor(new OldLoginInterceptor())
                .addPathPatterns("/admin/oldLogin");
        registry.addInterceptor(new AdminInterceptor())
                .addPathPatterns("/admin/*")
                .excludePathPatterns("/admin/oldLogin");
    }
}
