package com.example.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MyBeanTest2 {
    public String name;
    @Autowired
    @Qualifier("mytest2")
    public MyBean myBean;

    public MyBeanTest2(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyBeanTest{" +
                "name='" + name + '\'' +
                ", myBean=" + myBean +
                '}';
    }
}
