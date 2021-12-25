package com.example.demo.controller;

import com.example.demo.config.rabbitmq.HelloSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rabbitmq")
public class RabbitMQController {

    @Autowired
    private HelloSender helloSender;

    @GetMapping
    public void sent() {
        helloSender.send();
    }

}
