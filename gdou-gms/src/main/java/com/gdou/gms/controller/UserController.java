package com.gdou.gms.controller;

import com.gdou.gms.pojo.User;
import com.gdou.gms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController
{

    @Autowired
    private UserService userService;

    // 跳转到登录页面
    @GetMapping(value = {"/", "/login"})
    public String loginPage()
    {
        return "login";
    }

    @PostMapping("/login")
    public String login(User user, HttpSession session, Model model)
    {
        User loginUser = userService.login(user);
        if (loginUser != null)
        {
            // 登录成功
            session.setAttribute("user", loginUser);
            return "index";
        }
        else
        {
            // 失败
            model.addAttribute("msg", "账号或密码错误")
            return "login";
        }
    }



}
