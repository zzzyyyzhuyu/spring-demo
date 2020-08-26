package com.wimp.springdemo;

import com.wimp.springdemo.property.LibraryProperties;
import com.wimp.springdemo.property.ProfileProperties;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

/**
 * @author zhuyu
 */
@SpringBootApplication
public class SpringDemoApplication implements InitializingBean {

    @Resource
    private LibraryProperties libraryProperties;
    @Resource
    private ProfileProperties profileProperties;


    public static void main(String[] args) {
        SpringApplication.run(SpringDemoApplication.class, args);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(libraryProperties.getLocation());
        System.out.println(libraryProperties.getBooks());
        System.out.println(profileProperties.toString());
    }
}
