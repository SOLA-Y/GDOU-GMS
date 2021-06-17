package com.gdou.gms.service;

import com.gdou.gms.pojo.User;
import com.gdou.gms.pojo.UserInfo;
import com.gdou.gms.pojo.UserInfoExample;

import java.util.List;

public interface UserService
{

    public User login(User user);

    public boolean addAdministrator(UserInfo userInfo, User user);

    public boolean addUsers(List<UserInfo> userInfoList, List<User> userList);

    public boolean updatePassword(User user, String password);

    public boolean updateUserInfo(UserInfo userInfo);

    public UserInfo queryUserInfo(String userId);
    
    public List<UserInfo> queryAllUsers();

    public List<UserInfo> queryUsersByCondition(UserInfoExample example);

}
