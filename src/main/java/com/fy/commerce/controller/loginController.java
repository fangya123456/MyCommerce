package com.fy.commerce.controller;

import com.fy.commerce.model.ShopUser;
import com.fy.commerce.service.api.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by ya.fang on 2017/1/12.
 */
@Controller
@SessionAttributes({"USER_LOGIN","state"})
@RequestMapping("/loginPage")
@Api(value = "登录信息控制", description = "登录信息控制")
public class loginController {

    private Logger log = LogManager.getLogger(registController.class);

    @Autowired
    private IUserService userService;

    @ApiIgnore
    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    @ApiOperation(value = "用户登录", notes = "用户登录控制")
    public String userLogin(@ModelAttribute ShopUser user, ModelMap modelMap, HttpServletRequest request){
        //加密验证后登陆
        int loginState = userService.checkLoginInfo(user);
        modelMap.addAttribute("USER_LOGIN", user);
        modelMap.addAttribute("state", loginState);
        if (loginState < 0){
            log.info("登陆验证失败！");
            return "redirect:/login";
        }else{
            log.info("登陆验证成功！");
            return "redirect:/index";  //登录成功
        }
    }

    @ApiIgnore
    @RequestMapping(value = "/userLogout", method = RequestMethod.GET)
    @ApiOperation(value = "退出登录", notes = "退出登录控制")
    public String userLogout(ModelMap model, HttpServletRequest request, SessionStatus sessionStatus){
        //刷新退出前页面
        int beginIdx = ("http://"+request.getLocalAddr().toString()).length();
        String path = request.getHeader("Referer").substring(beginIdx);
        sessionStatus.setComplete();
        request.getSession().invalidate();
        log.info("退出登录");
        return  path;
    }
}