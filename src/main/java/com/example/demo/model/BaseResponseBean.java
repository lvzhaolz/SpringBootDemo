package com.example.demo.model;

import lombok.Data;

/**
 * @auther lvzhao
 * Created on 2020/12/18.
 */
@Data
public class BaseResponseBean<T> {
    private String code;
    private T data;
    private String message;

    public BaseResponseBean(String code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

}
