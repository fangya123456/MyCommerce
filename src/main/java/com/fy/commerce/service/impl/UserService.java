package com.fy.commerce.service.impl;

import com.fy.commerce.mapper.IUserMapper;
import com.fy.commerce.model.User;
import com.fy.commerce.service.api.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ya.fang on 2017/1/9.
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private IUserMapper userMapper;

    @Override
    public User findUserInfoById(int id) {
        return userMapper.selectUserInfoById(id);
    }

    @Override
    public User findUserInfoByExample(User user) {
        return userMapper.selectUserInfoByExample(user);
    }

    @Override
    @Transactional
    public int addUserInfoByExample(User user){
        return userMapper.insertUserInfoByExample(user);
    }
}
