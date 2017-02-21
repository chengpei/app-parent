package com.whpe.controller;

import com.whpe.bean.Result;
import com.whpe.service.LoginService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;

@Controller
public class LoginController extends CommonController{

    @Resource
    private LoginService loginService;

    @RequestMapping("/index/toIndex")
    public String index(){
        return "index";
    }

    @RequestMapping("/login/doLogin")
    @ResponseBody
    public Result doLogin(){
        loginService.doLogin();
        Result result = new Result(true, "登录成功");
        result.put("time", new Date());
        return result;
    }

}
