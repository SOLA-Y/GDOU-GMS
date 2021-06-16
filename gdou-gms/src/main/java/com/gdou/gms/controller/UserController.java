package com.gdou.gms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController
{
    // 跳转到登录页面
    @GetMapping(value = {"/", "/login"})
    public String loginPage()
    {
        return "login";
    }

    @PostMapping("/login")
    public String login()
    {

        return null;
    }

}
