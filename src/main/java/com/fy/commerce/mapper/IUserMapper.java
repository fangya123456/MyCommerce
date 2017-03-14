package com.fy.commerce.mapper;

import com.fy.commerce.model.User;

/**
 * Created by ya.fang on 2017/1/11.
 */
public interface IUserMapper {

    User selectUserInfoById(int id);

    User selectUserInfoByExample(User user);

    int insertUserInfoByExample(User user);
}
