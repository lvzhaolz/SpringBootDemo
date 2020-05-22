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

    @Test
    public void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        MyBeanTest myBeanTest1 = (MyBeanTest) context.getBean("MyBeanTest");
        MyBeanTest myBeanTest2 = (MyBeanTest) context.getBean("MyBeanTest2");
        MyBeanTest2 myBeanTest21 = context.getBean(MyBeanTest2.class);

        System.out.println(myBeanTest1 + "\n" + myBeanTest2 + "\n" + myBeanTest21);

    }

}
