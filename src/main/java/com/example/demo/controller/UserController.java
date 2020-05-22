package com.example.demo.controller;


import com.example.demo.entity.User;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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

    @RequestMapping("/get")
//    @ResponseBody
    public User get() {
        User user = userService.getById(1);
        return user;
    }

    @RequestMapping("/update")
    @Transactional
    public String update() {
        User user = userService.getById(1);
        user.setName("user1-2");
        boolean isUpdateById = userService.updateById(user);
        return user.toString() + "  isUpdateById  " + isUpdateById;
    }


}

