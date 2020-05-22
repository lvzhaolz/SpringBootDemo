package com.example.demo;

import com.example.demo.model.CustomBean;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class TestDemo {

    @Autowired
    @Qualifier("")
    private CustomBean customBean2;

    @Test
    public void testCustomBean() {
        System.out.println(customBean2);
    }

}
