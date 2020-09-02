package com.wimp.springdemo.interceptor;

import lombok.extern.log4j.Log4j2;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zy
 * @date 2020/9/2
 * <p>
 *  
 */
@Log4j2
public class OldLoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       log.info(" ---- OldLoginInterceptor preHandle ----");
       log.info("request url:"+request.getRequestURI());
       log.info("Sorry,the url is no longer used,redirect to /admin/login");

       response.sendRedirect(request.getContextPath()+"/admin/login");
       return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        log.info("OldLoginInterceptor postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        log.info("OldLoginInterceptor afterCompletion");
    }
}
