package com.example.demo.config.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig{
    // 交换机有四种类型,分别为Direct,topic,headers,Fanout.

    // Direct 模式创建队列
    // 创建队列
    @Bean
    public Queue testQueue() {
        return new Queue("queueName");
    }

    // 创建一个交换机
    @Bean
    public DirectExchange testExchange() {
        return new DirectExchange("exchangeName");
    }

    // 把队列和交换机绑定在一起
    @Bean
    public Binding testBinding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("routingKey");
    }
}