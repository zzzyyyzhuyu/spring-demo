package com.wimp.springdemo.filter;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author zy
 * @date 2020/8/31
 * <p>
 * 自定义过滤器，实现filter接口
 */
@Component
@Log4j2
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
        log.info("初始化过滤器1:",filterConfig.getFilterName());
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("过滤器开始对请求进行处理：");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String requestURI = request.getRequestURI();
        System.out.println("请求接口为："+requestURI);
        long startTime = System.currentTimeMillis();
        //通过 doFilter 方法实现过滤功能
        filterChain.doFilter(servletRequest,servletResponse);
        //上面的 doFilter 方法执行结束后用户的请求已经返回
        long endTime = System.currentTimeMillis();
        System.out.println("该请求的请求已经处理完毕，请求花费的时间的："+(endTime-startTime));
    }

    @Override
    public void destroy() {
        log.info("销毁过滤器");
    }
}
