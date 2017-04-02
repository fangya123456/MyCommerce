package com.fy.commerce.service.impl;

import com.fy.commerce.dao.ShopUserMapper;
import com.fy.commerce.model.ShopUser;
import com.fy.commerce.model.ShopUserExample;
import com.fy.commerce.service.api.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisServerCommands;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ya.fang on 2017/1/9.
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private ShopUserMapper userMapper;

    @Override
    public ShopUser findUserInfoById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public ShopUser findUserInfoByLoginInfo(ShopUser user) {
        String userInfo = user.getUserName();
        String password = user.getPassword();
        if (userInfo != null && password != null){
            ShopUserExample shopUserExample = new ShopUserExample();
            if (userInfo.contains("@")){
                shopUserExample.createCriteria().andPasswordEqualTo(password).andEmailEqualTo(userInfo);
            }else{
                shopUserExample.createCriteria().andPasswordEqualTo(password).andUserNameEqualTo(userInfo);
            }
            ShopUser user1 = userMapper.selectByExample(shopUserExample).get(0);
            return user1;
        }
        return null;
    }

    @Override
    @Transactional
    public int addUserInfoByExample(ShopUser user){
        return userMapper.insert(user);
    }
}
