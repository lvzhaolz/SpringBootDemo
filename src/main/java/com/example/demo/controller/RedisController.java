package com.example.demo.controller;

import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private IUserService userService;

    @GetMapping("/count")
    public String getAllUserCount() {
        //测试缓存穿透，多个线程都去查询数据库，这种现象就叫做缓存穿透，如果并发比较大，对数据库的压力过大，有可能造成数据库宕机。
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int index = i;
            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    userService.queryAllUserCount();
                }
            });
        }

        return String.valueOf(userService.queryAllUserCount());
    }

}
