package com.example.demo;

import com.example.demo.config.DemoConfig;
import com.example.demo.model.CustomBean;
import com.example.demo.model.MyBeanTest;
import com.example.demo.model.MyBeanTest2;
import com.example.demo.service.ActivitiService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDemo {

    @Autowired
    @Qualifier("customBean555")
    public CustomBean customBean;

    @Test
    public void testCustomBean() {
        System.out.println(customBean);
    }

    @Test
    public void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        MyBeanTest myBeanTest1 = (MyBeanTest) context.getBean("MyBeanTest");
        MyBeanTest myBeanTest2 = (MyBeanTest) context.getBean("MyBeanTest2");
        MyBeanTest2 myBeanTest21 = context.getBean(MyBeanTest2.class);
        System.out.println(myBeanTest1 + "\n" + myBeanTest2 + "\n" + myBeanTest21);
    }

    public static void main(String[] arg) {
        System.out.println(UUID.randomUUID().toString());
        System.out.println(UUID.randomUUID().toString());
        System.out.println(UUID.randomUUID().toString());
        System.out.println(UUID.randomUUID().toString());
    }

}
