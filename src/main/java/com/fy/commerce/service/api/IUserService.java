package com.fy.commerce.service.api;

import com.fy.commerce.model.ShopUser;

/**
 * Created by ya.fang on 2017/1/9.
 */

public interface IUserService {

    ShopUser findUserInfoById(int id);

    ShopUser findUserInfoByLoginInfo(ShopUser user);

    int addUserInfoByExample(ShopUser user);
}
