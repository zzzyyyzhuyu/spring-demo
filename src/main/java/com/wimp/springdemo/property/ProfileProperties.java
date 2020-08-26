package com.wimp.springdemo.property;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * @author zy
 * @date 2020/8/26
 * <p>
 *  
 */
@Component
@ConfigurationProperties("my-profile")
@Getter
@Setter
@ToString
public class ProfileProperties {
    @NotEmpty
    private String name;

    @Email
    @NotEmpty
    private String email;

    /**
     * 配置文件中没有读取到的话就用默认值
     */
    private Boolean handsome = Boolean.TRUE;
}
