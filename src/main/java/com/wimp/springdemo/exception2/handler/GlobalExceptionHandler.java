package com.wimp.springdemo.exception2.handler;


import com.wimp.springdemo.exception.ExceptionController;
import com.wimp.springdemo.exception2.BaseException;
import com.wimp.springdemo.exception2.ErrorResponse;
import com.wimp.springdemo.exception2.excption.ResourceNotFoundException;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zy
 * @date 2020/8/27
 * <p>
 *  全局异常处理 handler
 */
@RestControllerAdvice(assignableTypes = {ExceptionController.class})
@Log4j2
public class GlobalExceptionHandler implements InitializingBean {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<?> handleAppException(BaseException ex, HttpServletRequest request){
        ErrorResponse representation = new ErrorResponse(ex,request.getRequestURI());
        return  new ResponseEntity<>(representation,new HttpHeaders(),ex.getError().getHttpStatus());
    }

    /**
     * 优先匹配此异常，不符合才去寻找上级异常
     * @return
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException ex,HttpServletRequest request){
        ErrorResponse errorResponse = new ErrorResponse(ex, request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("全局异常处理启用");
    }
}
