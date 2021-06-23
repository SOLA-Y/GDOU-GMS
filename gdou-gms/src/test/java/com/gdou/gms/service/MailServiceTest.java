package com.gdou.gms.service;

import cn.hutool.core.thread.ThreadUtil;
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
        // mailService.sendSetMail(userInfo);

        // ThreadUtil.execAsync()

        try
        {
            mailService.sendSetMail(userInfo);
            System.out.println("发送成功");
        } catch (Exception e)
        {
            System.out.println("发送失败");
        }

    }

    @Test
    void sendRemoveMail()
    {
        UserInfo userInfo = new UserInfo(null, "林志宏", null, "refg2398467215@qq.com", null, null);
        mailService.sendRemoveMail(userInfo);
    }

    @Test
    void sendRandomStringMail()
    {
        // UserInfo userInfo = new UserInfo(null, "林志宏", null, "refg2398467215@qq.com", null, null);
        System.out.println(mailService.sendRandomStringMail(null));
    }
}