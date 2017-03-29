package com.whpe.controller;

import com.whpe.bean.Result;
import com.whpe.bean.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegisterController extends CommonController{

    @RequestMapping("/register/doRegister")
    @ResponseBody
    public Result doRegister(@RequestBody UserDto userDto){

        // TODO 插入用户信息

        Result result = new Result(true, "注册成功！");
        return result;
    }

    @RequestMapping("/register/sendSMSVerificationCode")
    @ResponseBody
    public Result sendSMSVerificationCode(String phoneNumber){

        // TODO 调用短信服务发送验证码

        Result result = new Result(true, "发送成功！");
        return result;
    }

    @RequestMapping("/register/checkPhone")
    @ResponseBody
    public Result checkPhone(String phoneNumber){

        // TODO 调用注册服务类，查询是否存在已经注册的用户

        Result result = new Result(false, "该手机号已经注册！");
        return result;
    }
}
