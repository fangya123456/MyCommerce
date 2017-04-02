package com.fy.commerce.controller;

import com.fy.commerce.model.ShopUser;
import com.fy.commerce.service.api.IUserService;
import io.swagger.annotations.Api;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by ya.fang on 2017/1/9.
 */
@Controller
@Api(value = "商城首页信息", description = "商城首页信息控制")
public class indexController {

    private Logger log = LogManager.getLogger(registController.class);
    @Autowired
    private IUserService userService;

    @ApiIgnore
    @RequestMapping(value = "/index", method = {RequestMethod.GET})
    public String index(Model model, HttpServletRequest request){

        log.info("index:访问首页");
        ShopUser user = (ShopUser)request.getSession().getAttribute("USER_LOGIN");
        String state = (String)request.getSession().getAttribute("state");
        if(user != null && state.equals("1")){
            model.addAttribute("user_login",user);
        }
        return "index";
    }

    @ApiIgnore
    @RequestMapping(value = "/login", method = {RequestMethod.GET})
    public String login(Model model, HttpServletRequest request){

        log.info("login:访问登录页");
        ShopUser user = (ShopUser)request.getSession().getAttribute("USER_LOGIN");
        String state = (String)request.getSession().getAttribute("state");
        if(state!=null){
            if (user == null && state.equals("2")){
                model.addAttribute("errMsg", "用户不存在");
            }else if(user != null && state.equals("3")){
                model.addAttribute("errMsg", "密码错误");
            }
        }
        return "login";
    }

    @ApiIgnore
    @RequestMapping(value = "/regist", method = {RequestMethod.GET})
    public String regist(Model model){

        return "regist";
    }

    @ApiIgnore
    @RequestMapping(value = "/product", method = {RequestMethod.GET})
    public String product(Model model, HttpServletRequest request, HttpSession httpSession){
        log.info("访问商城中心");
        ShopUser user = (ShopUser)request.getSession().getAttribute("USER_LOGIN");
        String state = (String)request.getSession().getAttribute("state");
        if(user != null && state.equals("1")){
            model.addAttribute("user_login",user);
        }
        return "product";
    }
}
