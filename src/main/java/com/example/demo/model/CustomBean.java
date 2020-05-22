package com.example.demo.model;

import org.springframework.beans.factory.annotation.Autowired;

public class CustomBean {
    private String name;

    public CustomBean(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CustomBean{" +
                "name='" + name + '\'' +
                '}';
    }
}