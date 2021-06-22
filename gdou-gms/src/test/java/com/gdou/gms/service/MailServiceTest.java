package com.gdou.gms.service;

import com.gdou.gms.pojo.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MailServiceTest
{

    @Autowired
    private MailService mailService;

    @Test
    void sendAddMail()
    {
        UserInfo userInfo = new UserInfo(null, "林志宏", null, "refg2398467215@qq.com", null, null);
        mailService.sendSetMail(userInfo);
    }

    @Test
    void sendRemoveMail()
    {
        UserInfo userInfo = new UserInfo(null, "林志宏", null, "refg2398467215@qq.com", null, null);
        mailService.sendRemoveMail(userInfo);
    }
    
}