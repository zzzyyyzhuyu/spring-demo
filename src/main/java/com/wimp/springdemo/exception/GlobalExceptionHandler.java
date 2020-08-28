package com.wimp.springdemo.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zy
 * @date 2020/8/27
 * <p>
 *  异常处理
 *  CotroolerAdvice方式 处理某一个类的异常
 */
//@ControllerAdvice(assignableTypes = {ExceptionController.class})
//@ResponseBody
public class GlobalExceptionHandler {
    ErrorResponse illegalArgumentResponse = new ErrorResponse(new IllegalArgumentException("参数错误!"));
    ErrorResponse resourseNotFoundResponse = new ErrorResponse(new ResourceNotFoundException("Sorry, the resourse not found!"));

    /**
     * 拦截处理，处理某一种异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(Exception e) {

        if (e instanceof IllegalArgumentException) {
            return ResponseEntity.status(400).body(illegalArgumentResponse);
        } else if (e instanceof ResourceNotFoundException) {
            return ResponseEntity.status(404).body(resourseNotFoundResponse);
        }
        return ResponseEntity.status(405).body(resourseNotFoundResponse);
    }
}
