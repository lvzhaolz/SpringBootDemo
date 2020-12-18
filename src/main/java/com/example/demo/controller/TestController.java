package com.example.demo.controller;

import com.example.demo.model.BaseResponseBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @auther lvzhao
 * Created on 2020/12/18.
 */
@RestController
@RequestMapping
public class TestController {

    @GetMapping("/test")
    public BaseResponseBean<String> test(HttpServletRequest request, HttpServletResponse response) {
        return new BaseResponseBean<>("0", "sss", "message");
    }

    @GetMapping("/test2")
    public BaseResponseBean<String> test2(HttpServletRequest request, HttpServletResponse response) {
        return new BaseResponseBean<>("1", "sss", "message");
    }

}
