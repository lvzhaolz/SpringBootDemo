package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.constant.RedisConstants;
import com.example.demo.model.po.UserPO;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author lvzhao
 * @since 2020-05-14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserPO> implements IUserService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Integer queryAllUserCount() {
        //设置redisTemplate对象的key的序列化方式
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //从redis缓存中获取总数log4j.appender.appenderName
        Object result = redisTemplate.opsForValue().get(RedisConstants.ALL_USER_COUNT);

        //判断总数是否为空，双重检测
        if (null == result) {
            synchronized (this) {
                result = redisTemplate.opsForValue().get(RedisConstants.ALL_USER_COUNT);
                //双重检测
                if (null == result) {
                    System.out.println("read database");
                    //从数据库获取
                    result = getRealCount();
                    //放入Redis缓存
                    redisTemplate.opsForValue().set(RedisConstants.ALL_USER_COUNT, result, 60, TimeUnit.SECONDS);
                } else {
                    System.out.println("read redis");
                }
            }
        } else {
            System.out.println("read redis");
        }

        int count = (int) result;

        return count;
    }

    @Transactional
    public int getRealCount() {
        return count();
    }

}
