package com.example.demo.controller;

import com.example.demo.model.CustomBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class InterfaceTest {

//    @Value("${test.name}")
    private String testName;

    @Autowired
    @Qualifier("customBean55")
    private CustomBean customBean;

    @RequestMapping("/hello")
    public String hello() {
        return "hello world" + customBean.toString() + " testName " + testName;
    }

}
