package com.example.demo.service;

import com.example.demo.model.po.UserPO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author lvzhao
 * @since 2020-05-14
 */
public interface IUserService extends IService<UserPO> {

    Integer queryAllUserCount();

}
