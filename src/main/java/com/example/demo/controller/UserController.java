package com.example.demo.controller;

import com.example.demo.model.Result;
import com.example.demo.model.po.UserPO;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * @author lvzhao
 * @since 2020-05-14
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/get")
    public Result<UserPO> get() {
        UserPO userPO = userService.getById("1");
        return new Result<>("0", userPO, "");
    }

    @PutMapping("/update")
    @Transactional
    public String update() {
        UserPO userPO = userService.getById("1");
        userPO.setUsername("user1-2");
        boolean isUpdateById = userService.updateById(userPO);
        return userPO.toString() + "  isUpdateById  " + isUpdateById;
    }


}

