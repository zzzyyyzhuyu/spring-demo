package com.wimp.springdemo.filter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zy
 * @date 2020/8/31
 * <p>
 *  
 */
@RestController
@RequestMapping("/filterApi")
public class FilterController {

    @GetMapping("/filter")
    public String filter(){
        return "filter";
    }
}
