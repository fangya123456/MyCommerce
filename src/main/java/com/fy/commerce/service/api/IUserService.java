package com.fy.commerce.service.api;

import com.fy.commerce.model.User;

/**
 * Created by ya.fang on 2017/1/9.
 */

public interface IUserService {

    User findUserInfoById(int id);

    User findUserInfoByExample(User user);

    int addUserInfoByExample(User user);
}
