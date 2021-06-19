package com.gdou.gms.service;

import com.gdou.gms.pojo.User;
import com.gdou.gms.pojo.UserInfo;
import com.gdou.gms.pojo.UserInfoExample;

import java.util.List;

public interface UserService
{

    public UserInfo login(User user);

    public Boolean addAdministrator(UserInfo userInfo, User user);

    public Boolean addUsers(List<UserInfo> userInfoList, List<User> userList);

    public Boolean updatePassword(String originalPassword, User user);

    public Boolean updateUserInfo(UserInfo userInfo);

    public UserInfo queryUserInfo(String userId);

    public List<UserInfo> queryAllUsers();

    public List<UserInfo> queryUsersByCondition(UserInfoExample example);

}
