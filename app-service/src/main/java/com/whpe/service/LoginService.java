package com.whpe.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class LoginService extends CommonService{

    @Value("${jdbc.username}")
    private String username;

    public void doLogin() {
        logger.info("【"+username+"】登陆操作！！！！");
    }
}
