package com.gdou.gms.service;

import com.gdou.gms.pojo.Condition;
import com.gdou.gms.pojo.User;
import com.gdou.gms.pojo.UserInfo;

import java.util.List;

public interface UserService
{

    public UserInfo login(User user);

    public UserInfo setAdministrator(String userId);

    public Integer addUsers(String jsonString);

    public Boolean updatePassword(String originalPassword, User user);

    public Boolean updateUserInfo(UserInfo userInfo);

    public UserInfo queryUserInfo(String userId);

    public List<UserInfo> queryAllUsers();

    public List<UserInfo> queryUsersByCondition(Condition condition);

    public Boolean deleteUser(String userId);

    public UserInfo removeAdministrator(String userId);

}
