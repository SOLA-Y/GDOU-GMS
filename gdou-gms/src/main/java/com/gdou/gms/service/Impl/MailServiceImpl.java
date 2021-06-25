package com.gdou.gms.service.Impl;

import com.gdou.gms.pojo.UserInfo;
import com.gdou.gms.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Date;

@Async
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
    @Value("${main.content.validate.prefix}")
    private String validatePrefixContent;
    @Value("${main.content.validate.suffix}")
    private String validateSuffixContent;

    @Override
    public Boolean sendSetMail(UserInfo userInfo)
    {
        try
        {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(from);
            mailMessage.setTo(userInfo.getMail());
            mailMessage.setCc(from);
            mailMessage.setSubject(subject);
            mailMessage.setText(userInfo.getUsername() + setContent + from);
            javaMailSender.send(mailMessage);

            return true;
        } catch (MailException e)
        {
            return false;
        }
    }

    @Override
    public Boolean sendRemoveMail(UserInfo userInfo)
    {
        try
        {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(from);
            mailMessage.setTo(userInfo.getMail());
            mailMessage.setCc(from);
            mailMessage.setSubject(subject);
            mailMessage.setText(userInfo.getUsername() + removeContent + from);
            javaMailSender.send(mailMessage);

            return true;
        } catch (MailException e)
        {
            return false;
        }
    }

    @Override
    public Boolean sendValidateCodeMail(UserInfo userInfo, String validateCode, Date sendTime)
    {
        try
        {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(from);
            mailMessage.setTo(userInfo.getMail());
            mailMessage.setSubject(subject);
            mailMessage.setText(userInfo.getUsername() + validatePrefixContent + validateCode + validateSuffixContent);
            javaMailSender.send(mailMessage);

            return true;
        } catch (MailException e)
        {
            return false;
        }

    }

}
