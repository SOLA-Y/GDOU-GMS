package com.gdou.gms.service;

import com.gdou.gms.pojo.UserInfo;

import java.util.Date;

public interface MailService
{

    public Boolean sendSetMail(UserInfo userInfo);
    
    public Boolean sendRemoveMail(UserInfo userInfo);

    public Boolean sendValidateCodeMail(UserInfo userInfo, String validateCode, Date sendTime);

}
