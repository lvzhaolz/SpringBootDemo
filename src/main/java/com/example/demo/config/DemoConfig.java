package com.example.demo.config;

import com.example.demo.model.MyBean;
import com.example.demo.model.MyBeanTest;
import com.example.demo.model.MyBeanTest2;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoConfig {

    @Bean
    public MyBean mytest() {
        return new MyBean("myBean1");
    }

    @Bean
    public MyBean mytest2() {
        return new MyBean("mybean2");
    }

    @Bean
    public MyBeanTest MyBeanTest(@Qualifier("mytest") MyBean mytest) {
        return new MyBeanTest("mybeantest1", mytest);
    }

    @Bean
    public MyBeanTest MyBeanTest2(@Qualifier("mytest2") MyBean mytest) {
        return new MyBeanTest("mybeantest2", mytest);
    }

    @Bean
    public MyBeanTest2 MyBeanTest21() {
        return new MyBeanTest2("MyBeanTest21");
    }

}
