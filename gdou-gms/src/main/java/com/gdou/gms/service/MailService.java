package com.gdou.gms.service;

import com.gdou.gms.pojo.UserInfo;

public interface MailService
{

    public Boolean sendSetMail(UserInfo userInfo);
    
    public Boolean sendRemoveMail(UserInfo userInfo);

    public String sendRandomStringMail(UserInfo userInfo);

}
