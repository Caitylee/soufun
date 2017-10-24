package com.qf.house.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 异常处理Aop
 * @author yangbo
 */

//@ControllerAdvice
public class MyExceptionAdvice {

    @ExceptionHandler({Exception.class})
    public String AllExceptionHandler(){
        return "error/hint";
    }


}
