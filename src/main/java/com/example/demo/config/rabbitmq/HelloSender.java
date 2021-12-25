package com.example.demo.config.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// 消息生产者
@Component
public class HelloSender {
    @Autowired
    private RabbitTemplate template;

    public void send() {
        template.convertAndSend("exchangeName", "routingKey", "hello,rabbit~");
    }
}