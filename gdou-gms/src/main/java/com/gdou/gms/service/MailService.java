package com.gdou.gms.service;

import com.gdou.gms.pojo.UserInfo;

public interface MailService
{

    public void sendSetMail(UserInfo userInfo);
    
    public void sendRemoveMail(UserInfo userInfo);

    public String sendRandomStringMail(UserInfo userInfo);

}
