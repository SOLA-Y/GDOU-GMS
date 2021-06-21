package com.gdou.user.controller;

import com.gdou.user.pojo.User;
import com.gdou.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/gdou_user")
public class UserController
{

    @Autowired
    private IUserService userService;

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers()
    {
        return userService.getAllUsers();
    }

}
