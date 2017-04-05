package com.fy.commerce.controller;

import com.fy.commerce.model.ShopUser;
import com.fy.commerce.service.api.IUserService;
import com.fy.commerce.utils.CipherUtil;
import com.fy.commerce.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ya.fang on 2017/1/11.
 */
@Controller
@RequestMapping("/regist")
@Api(value = "用户注册信息", description = "用户注册信息控制")
public class registController {

    private Logger log = LogManager.getLogger(registController.class);
    @Autowired
    private IUserService userService;

    /**
     * 用于处理Date类型参数处理
     * @return
     */
    @InitBinder
    protected  void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));

    }

    @ResponseBody
    @RequestMapping(value = "/insertUserInfo", method = RequestMethod.POST)
    public Result insertUserInfo(@ModelAttribute ShopUser user, HttpServletRequest request){

        user.setPassword(CipherUtil.generatePassword(user.getPassword()));
        return new Result(200, userService.addUserInfoByExample(user));
    }

    @ResponseBody
    @RequestMapping(value = "/validateUsername", method = RequestMethod.GET)
    @ApiOperation(value = "校验用户信息", notes = "校验用户信息接口")
    public Result validateUsername(@RequestParam("userName") String username){
        log.info("username:"+username);
        ShopUser user = new ShopUser();
        user.setUserName(username);
        if (userService.checkRegistInfo(user)){
            return new Result(200,0);
        }
        return new Result(200, 1);
    }

    @ResponseBody
    @RequestMapping(value = "/validateEmail", method = RequestMethod.GET)
    @ApiOperation(value = "校验用户信息", notes = "校验用户信息接口")
    public Result validateEmail(@RequestParam("email") String email){

        log.info("email:"+email);
        ShopUser user = new ShopUser();
        user.setEmail(email);
        if (userService.checkRegistInfo(user)){
            return new Result(200,0);
        }
        return new Result(200, 1);
    }
}
