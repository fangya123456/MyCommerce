package com.fy.commerce.utils;

/**
 * Created by dell-pc on 2017/4/5.
 */
public interface ResultCode {

    //请求状态码
    int RESULT_CODE_C200 = 200;  //请求成功
    int RESULT_CODE_C300 = 300;  //请求重定向
    int RESULT_CODE_C400 = 400;  //客户端错误
    int RESULT_CODE_C500 = 500;  //服务器错误


    //登录信息提示状态码
    int LOGIN_STATE_SUCCESS = 1;   //登陆成功
    int LOGIN_STATE_FAIL_1 = -1;   //登录用户名或密码为空
    int LOGIN_STATE_FAIL_2 = -2;   //登录用户名不存在或用户名错误
    int LOGIN_STATE_FAIL_3 = -3;   //登录密码错误
    int LOGIN_STATE_FAIL_4 = -4;   //用户未激活
    int LOGIN_STATE_FAIL_5 = -5;   //用户已注销

    //商城页
    int Product_PAGE_NUM = 5;
    int Product_PAGE_SIZE = 20;
}
