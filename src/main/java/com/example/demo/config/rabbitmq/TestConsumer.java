package com.example.demo.config.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

// 定义消费者
@Component
@Slf4j
public class TestConsumer {

    @RabbitListener(queues = "queueName")
    public void process(String data) {
        log.info("------------data: {}", data);
    }
}