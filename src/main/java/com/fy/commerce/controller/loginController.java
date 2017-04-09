package com.fy.commerce.controller;

import com.fy.commerce.model.ShopUser;
import com.fy.commerce.service.api.IUserService;
import com.fy.commerce.utils.CaptchaUtil;
import com.fy.commerce.utils.Result;
import com.fy.commerce.utils.ResultCode;
import com.fy.commerce.vo.UserInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import springfox.documentation.annotations.ApiIgnore;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by ya.fang on 2017/1/12.
 */
@Controller
@SessionAttributes({"USER_LOGIN","STATE","SESSION_CODE_NAME"})
@RequestMapping("/login")
@Api(value = "登录信息控制", description = "登录信息控制")
public class loginController {

    private Logger log = LogManager.getLogger(registController.class);

    @Autowired
    private IUserService userService;

    @ResponseBody
    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    @ApiOperation(value = "用户登录", notes = "用户登录控制")
    public Result userLogin(@ModelAttribute UserInfoVo loginUser, ModelMap modelMap, HttpServletRequest request){
        //加密验证后登陆
        String errMsg = "OK";
        int resultCode = ResultCode.RESULT_CODE_C200;
        int loginState = 0;
        try{
            String validateCode = (String )request.getSession().getAttribute("SESSION_CODE_NAME");
            if (validateCode == null || !loginUser.getCaptcha().toLowerCase().equals(validateCode.toLowerCase())){
                log.info("登陆验证失败！");
                errMsg = "验证码错误！";
            }else {
                ShopUser user = new ShopUser();
                BeanUtils.copyProperties(loginUser, user);
                loginState = userService.checkLoginInfo(user);
                if (loginState == ResultCode.LOGIN_STATE_FAIL_4){
                    log.info("登陆验证失败！");
                    errMsg = "用户未激活！";
                }else if (loginState == ResultCode.LOGIN_STATE_FAIL_5){
                    log.info("登陆验证失败！");
                    errMsg = "用户已注销！";
                }else if (loginState == ResultCode.LOGIN_STATE_FAIL_1){
                    log.info("登陆验证失败！");
                    errMsg = "登录用户名或密码为空！";
                }else if (loginState == ResultCode.LOGIN_STATE_FAIL_2){
                    log.info("登陆验证失败！");
                    errMsg = "用户名不存在或错误！";
                }else if (loginState == ResultCode.LOGIN_STATE_FAIL_3){
                    log.info("登陆验证失败！");
                    errMsg = "登录密码错误！";
                } else if (loginState == ResultCode.LOGIN_STATE_SUCCESS){
                    log.info("登陆验证成功！");
                    modelMap.addAttribute("USER_LOGIN", user);
                    modelMap.addAttribute("STATE", loginState+"");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            errMsg = "服务器内部错误！";
            resultCode = ResultCode.RESULT_CODE_C500;
        }finally {
            return new Result(resultCode, errMsg, loginState);
        }
    }

    @ApiIgnore
    @RequestMapping(value = "/userLogout", method = RequestMethod.GET)
    @ApiOperation(value = "退出登录", notes = "退出登录控制")
    public String userLogout(ModelMap model, HttpServletRequest request, SessionStatus sessionStatus){
        //刷新退出前页面

        String[] path = request.getHeader("Referer").split("/");
        sessionStatus.setComplete();
        log.info("退出登录");
        return  path[path.length-1];
    }

    @ResponseBody
    @RequestMapping(value = "/createCode", method = RequestMethod.GET)
    @ApiOperation(value = "生成验证码", notes = "生成验证码控制")
    public Result createCode(ModelMap model, HttpServletRequest request){
        String validateCode = CaptchaUtil.createCode();
        model.addAttribute("SESSION_CODE_NAME", validateCode);
        return  new Result(ResultCode.RESULT_CODE_C200, validateCode);
    }

}