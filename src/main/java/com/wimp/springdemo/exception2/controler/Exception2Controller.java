package com.wimp.springdemo.exception2.controler;

import com.wimp.springdemo.exception.ResourseNotFoundException2;
import com.wimp.springdemo.exception2.BaseException;
import com.wimp.springdemo.exception2.ErrorCode;
import com.wimp.springdemo.exception2.excption.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/**
 * @author zy
 * @date 2020/8/27
 * <p>
 *  
 */
@RestController
@RequestMapping("/api2")
public class Exception2Controller {

    @GetMapping("/baseException")
    public void throwException() {
        throw new BaseException(ErrorCode.REQUEST_VALIDATION_FAILED,null);
    }

    @GetMapping("/resourceNotFoundException")
    public void throwResouceNotFoundException(){
        throw new ResourceNotFoundException(null);
    }




}
