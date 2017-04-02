package com.fy.commerce.controller;

import com.fy.commerce.model.ShopUser;
import com.fy.commerce.service.api.IUserService;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by ya.fang on 2017/1/13.
 */
@Controller
@RequestMapping("/login1")
public class loginDeal {
    private Logger log = LogManager.getLogger(registController.class);

    @Autowired
    private IUserService userService;

    @ApiIgnore
    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    @ApiOperation(value = "用户登录", notes = "用户登录控制")
    public String userLogin(@ModelAttribute ShopUser user, Model model, HttpServletRequest request){

        HttpSession session = request.getSession();
        ShopUser queryUser = userService.findUserInfoByLoginInfo(user);
        log.info("QueryUser:"+user.getUserName());
        session.setAttribute("USER_LOGIN", queryUser);
        if(queryUser == null){
            log.info("用户不存在");
            session.setAttribute("state", "2"); //用户不存在
            return "redirect:/login";
        } else if(!queryUser.getPassword().equals(user.getPassword())){
            log.info("密码错误");
            session.setAttribute("state", "3"); //密码错误
            return "redirect:/login";
        } else{
            session.setAttribute("state", "1");
            return "redirect:/index";  //登录成功
        }
    }

    @ApiIgnore
    @RequestMapping(value = "/userLogout", method = RequestMethod.GET)
    @ApiOperation(value = "退出登录", notes = "退出登录控制")
    public String userLogout(ModelMap model, HttpServletRequest request){

        HttpSession session = request.getSession(false);
        if (session != null){
            session.removeAttribute("USER_LOGIN");
            session.removeAttribute("state");
            log.info("UserLogout:"+request.getSession().getAttribute("state"));
            log.info("退出登录");
        }
        return  "redirect:/index";
    }

}
