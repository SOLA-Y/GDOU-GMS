package com.gdou.gms.service;

import com.gdou.gms.pojo.UserInfo;
import com.gdou.gms.util.RandomCharUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootTest
class MailServiceTest
{

    @Autowired
    private MailService mailService;

    @Autowired
    private JavaMailSender javaMailSender;


    @Value("${mail.from}")
    private String from;
    @Value("${mail.subject}")
    private String subject;
    @Value("${mail.content.set}")
    private String setContent;
    @Value("${mail.content.remove}")
    private String removeContent;
    @Value("${main.content.validate.prefix}")
    private String validatePrefixContent;
    @Value("${main.content.validate.suffix}")
    private String validateSuffixContent;

    @Test
    public void test()
    {
        UserInfo userInfo = new UserInfo(null, "甘燿生", null, "1229655503@qq.com", null, null);

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(from);
        mailMessage.setTo(userInfo.getMail());
        mailMessage.setCc(from);
        mailMessage.setSubject(subject);
        mailMessage.setText(userInfo.getUsername() + setContent + from);
        javaMailSender.send(mailMessage);

        System.out.println("发送成功");

    }

    @Test
    void sendAddMail()
    {
        UserInfo userInfo = new UserInfo(null, "甘燿生", null, "1229655503@qq.com", null, null);

        try
        {
            mailService.sendSetMail(userInfo);
            System.out.println("添加成功");

        } catch (Exception e)
        {
            System.out.println("添加失败");
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
        // System.out.println("最后验证码：" + mailService.sendValidateCodeMail(null));

        System.out.println(RandomCharUtil.createValidateCode());
    }
}