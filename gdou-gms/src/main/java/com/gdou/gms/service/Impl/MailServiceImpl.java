package com.gdou.gms.service.Impl;

import cn.hutool.core.util.RandomUtil;
import com.gdou.gms.pojo.UserInfo;
import com.gdou.gms.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@PropertySource(value = {"classpath:mail.properties"})
public class MailServiceImpl implements MailService
{

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

    @Override
    public void sendSetMail(UserInfo userInfo)
    {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(from);
        mailMessage.setTo(userInfo.getMail());
        mailMessage.setCc(from);
        mailMessage.setSubject(subject);
        mailMessage.setText(userInfo.getUsername() + setContent + from);

        javaMailSender.send(mailMessage);
    }

    @Override
    public void sendRemoveMail(UserInfo userInfo)
    {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(from);
        mailMessage.setTo(userInfo.getMail());
        mailMessage.setCc(from);
        mailMessage.setSubject(subject);
        mailMessage.setText(userInfo.getUsername() + removeContent + from);

        javaMailSender.send(mailMessage);
    }

    @Override
    public String sendRandomStringMail(UserInfo userInfo)
    {
        String randomChars = "";
        for (int i = 0; i < 6; i++)
        {
            randomChars += RandomUtil.randomChar();
        }

        return randomChars;
    }


}
