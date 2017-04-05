package com.fy.commerce.service.impl;

import com.fy.commerce.dao.ShopUserMapper;
import com.fy.commerce.model.ShopUser;
import com.fy.commerce.model.ShopUserExample;
import com.fy.commerce.service.api.IUserService;
import com.fy.commerce.utils.CipherUtil;
import com.fy.commerce.utils.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

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
    public Boolean checkRegistInfo(ShopUser user) {
        if (user != null){
            ShopUserExample shopUserExample = new ShopUserExample();
            if (user.getUserName() != null){
                shopUserExample.createCriteria().andUserNameEqualTo(user.getUserName());
            }else if(user.getEmail() != null){
                shopUserExample.createCriteria().andEmailEqualTo(user.getEmail());
            }
            if (userMapper.selectByExample(shopUserExample).size() == 1){
                return true;
            }
        }
        return false;
    }

    public int checkLoginInfo(ShopUser user) {
        String userInfo = user.getUserName();
        String password = user.getPassword();
        if (userInfo != null && password != null) {
            ShopUserExample shopUserExample = new ShopUserExample();
            if (userInfo.contains("@")) {
                shopUserExample.createCriteria().andEmailEqualTo(userInfo);
            } else {
                shopUserExample.createCriteria().andUserNameEqualTo(userInfo);
            }
            List<ShopUser> list = userMapper.selectByExample(shopUserExample);
            if (list.size() == 0){
                return ResultCode.LOGIN_STATE_FAIL_2; // 用户名不存在或用户名错误
            }else{
                if (!CipherUtil.validatePassword(list.get(0).getPassword(), password)){
                    return ResultCode.LOGIN_STATE_FAIL_3; //密码不正确
                }
                return ResultCode.LOGIN_STATE_SUCCESS; //登陆成功
            }
        }
        return ResultCode.LOGIN_STATE_FAIL_1; //用户名或密码不能为空
    }

    @Override
    @Transactional
    public int addUserInfoByExample(ShopUser user){

        user.setCode(UUID.randomUUID().toString());
        user.setState(0);
        user.setIsDel(0);

        //SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        user.setCreateTime(new Date());// new Date()为获取当前系统时间
        String userNumber = "MC_1000000";
        user.setUserNumber(userNumber);
        int id = userMapper.insert(user);
        if (id > 0){
            userNumber = userNumber+id;
            user.setUserNumber(userNumber);
            return userMapper.updateByPrimaryKeySelective(user);
        }
        return 0;
    }
}
