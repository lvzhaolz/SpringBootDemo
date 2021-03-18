package com.example.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author lvzhao
 * @since 2021/3/1.
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Throwable.class)
    public String handlerError(Throwable t) {
        log.debug("-global-exception-handler-{}", t);
        return t.getMessage();
    }

}
