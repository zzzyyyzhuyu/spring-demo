package com.wimp.springdemo.sevletLifeCycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zy
 * @date 2020/8/25
 * <p>
 *  
 */
@Configuration
public class MyServletConfigSpring implements InitializingBean, DisposableBean {

    public MyServletConfigSpring(){
        System.out.println("Init MyServletConfigSpring");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("after Init MyServletConfigSpring");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("before destroy MyServletConfigSpring");
    }

}
