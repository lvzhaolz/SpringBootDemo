package com.example.demo.model;

public class MyBeanTest {
    public String name;
    public MyBean myBean;

    public MyBeanTest(String name, MyBean myBean) {
        this.name = name;
        this.myBean = myBean;
    }

    @Override
    public String toString() {
        return "MyBeanTest{" +
                "name='" + name + '\'' +
                ", myBean=" + myBean +
                '}';
    }
}
