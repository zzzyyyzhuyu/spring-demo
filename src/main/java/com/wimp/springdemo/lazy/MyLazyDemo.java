package com.wimp.springdemo.lazy;

import com.wimp.springdemo.sevletLifeCycle.MyServletConfig;
import org.springframework.context.annotation.Configuration;

/**
 * @author zy
 * @date 2020/8/25
 * <p>
 *  
 */
@Configuration
public class MyLazyDemo {
    private volatile static MyServletConfig myServletConfig;

    public MyLazyDemo(){

    }

    public static MyServletConfig getMyServletConfig(){
        if(null == myServletConfig){
            synchronized(myServletConfig){
                if(null == myServletConfig){
                    myServletConfig = new MyServletConfig();
                }
            }
        }
        return myServletConfig;
    }
}
