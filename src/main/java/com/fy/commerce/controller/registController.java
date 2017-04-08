package com.fy.commerce.controller;

import com.fy.commerce.model.ShopUser;
import com.fy.commerce.service.api.IUserService;
import com.fy.commerce.utils.CipherUtil;
import com.fy.commerce.utils.Result;
import com.fy.commerce.utils.ResultCode;
import com.fy.commerce.vo.UserInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
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
@SessionAttributes({"SESSION_CODE_NAME"})
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
    public Result insertUserInfo(@ModelAttribute UserInfoVo registerUser, HttpServletRequest request){

        String errMsg = "OK";
        int resultCode = ResultCode.RESULT_CODE_C200;
        int registerState = 0;
        try{
            String validateCode = (String )request.getSession().getAttribute("SESSION_CODE_NAME");
            if (validateCode == null || !registerUser.getCaptcha().toLowerCase().equals(validateCode.toLowerCase())){
                log.info("注册验证失败！");
                errMsg = "验证码错误！";
            }else{
                registerUser.setPassword(CipherUtil.generatePassword( registerUser.getPassword()));
                ShopUser user = new ShopUser();
                BeanUtils.copyProperties(registerUser, user);
                if (userService.addUserInfoByExample(user) > 0){
                    registerState = 1;
                    errMsg = "注册成功！";
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            errMsg = "服务器异常";
            resultCode = ResultCode.RESULT_CODE_C500;
        }finally {
            return new Result(resultCode, errMsg, registerState);
        }
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
