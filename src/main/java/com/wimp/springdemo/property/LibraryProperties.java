package com.wimp.springdemo.property;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zy
 * @date 2020/8/26
 * <p>
 *  
 */
@Component
@ConfigurationProperties("library")
@Getter
@Setter
@ToString
public class LibraryProperties {
    private String location;
    private List<Book> books;

    @Getter
    @Setter
    @ToString
    static class Book{
        private String name;
        private String description;
    }
}
