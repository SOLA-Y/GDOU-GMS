package com.gdou.gms.service;

import com.gdou.gms.pojo.User;
import com.gdou.gms.pojo.UserInfo;
import com.gdou.gms.util.Encrypt;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceTest
{
    @Autowired
    private UserService userService;

    @Test
    void updateUser()
    {
        String password = Encrypt.encryptMD5("1234567890");

        UserInfo userInfo = new UserInfo();
        userInfo.setUserid("201811701307");
        // userInfo.setMail("12296@qq.com");

        // 1234567890：e807f1fcf82d132f9bb018ca6738a19f
        // 123456789：25f9e794323b453885f5181f1b624d0b

        User user = new User(userInfo.getUserid() + "2", password, null);

        // userService.updateUser(userInfo, user);

    }
}