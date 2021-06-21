package com.gdou.user.service.Impl;

import com.gdou.user.mapper.UserMapper;
import com.gdou.user.pojo.User;
import com.gdou.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IUserServiceImpl implements IUserService
{
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAllUsers()
    {
        return userMapper.selectByExample(null);
    }
}
