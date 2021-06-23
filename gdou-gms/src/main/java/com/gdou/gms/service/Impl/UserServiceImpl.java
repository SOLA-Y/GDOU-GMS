package com.gdou.gms.service.Impl;

import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.json.JSONUtil;
import com.gdou.gms.mapper.UserInfoMapper;
import com.gdou.gms.mapper.UserMapper;
import com.gdou.gms.pojo.Condition;
import com.gdou.gms.pojo.User;
import com.gdou.gms.pojo.UserInfo;
import com.gdou.gms.pojo.UserInfoExample;
import com.gdou.gms.service.UserService;
import com.gdou.gms.util.ExampleUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo login(User user)
    {
        List<User> userList = userMapper.selectByExample(null);
        String password = DigestUtil.md5Hex(user.getPassword());

        for (User user1 : userList)
        {
            if (user.getUserid().equals(user1.getUserid()) && password.equals(user1.getPassword()))
            {
                return userInfoMapper.selectByPrimaryKey(user1.getUserid());
            }
        }

        return null;
    }

    // @Transactional：事务，将下面的所有操作视为一个操作，所有操作成功才提交到数据库，不然就回滚
    @Transactional
    @Override
    public UserInfo setAdministrator(String userId)
    {
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(userId);
        userInfo.setRoleid(2);

        User user = new User(userId, null, 2);

        userInfoMapper.updateByPrimaryKeySelective(userInfo);
        userMapper.updateByPrimaryKeySelective(user);

        return userInfo;
    }

    @Transactional
    @Override
    public Integer addUsers(String jsonString)
    {
        int insert1 = 0;
        int insert2 = 0;

        List<UserInfo> userInfoList = JSONUtil.toList(jsonString, UserInfo.class);

        for (UserInfo userInfo : userInfoList)
        {
            // 数据库中不存在用户才插入到表中
            if (userInfoMapper.selectByPrimaryKey(userInfo.getUserid()) == null)
            {
                userInfo.setRoleid(1);
                insert1 += userInfoMapper.insert(userInfo);

                String password = DigestUtil.md5Hex(userInfo.getUserid());
                User user = new User(userInfo.getUserid(), password, 1);
                insert2 += userMapper.insert(user);
            }
        }

        return insert1 == insert2 ? insert1 : -1;
    }

    @Override
    public Boolean updatePassword(String originalPassword, User user)
    {
        String password = DigestUtil.md5Hex(originalPassword);
        User dbUser = userMapper.selectByPrimaryKey(user.getUserid());

        if (password.equals(dbUser.getPassword()))
        {
            user.setPassword(DigestUtil.md5Hex(user.getPassword()));
            int update = userMapper.updateByPrimaryKeySelective(user);

            return update == 1;
        }

        return false;
    }

    @Override
    public Boolean updateUserInfo(UserInfo userInfo)
    {
        int update = userInfoMapper.updateByPrimaryKeySelective(userInfo);

        return update == 1;
    }

    @Override
    public UserInfo queryUserInfo(String userId)
    {
        return userInfoMapper.selectByPrimaryKey(userId);
    }

    @Override
    public List<UserInfo> queryAllUsers()
    {
        return userInfoMapper.selectByExample(null);
    }

    @Override
    public List<UserInfo> queryUsersByCondition(Condition condition)
    {
        System.out.println(condition);

        UserInfoExample example = ExampleUtil.createUserInfoExample(condition);
        return userInfoMapper.selectByExample(example);
    }

    @Transactional
    @Override
    public Boolean deleteUser(String userId)
    {
        int delete1 = userMapper.deleteByPrimaryKey(userId);
        int delete2 = userInfoMapper.deleteByPrimaryKey(userId);

        return delete1 == 1 && delete2 == 1;
    }

    @Transactional
    @Override
    public UserInfo removeAdministrator(String userId)
    {
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(userId);
        userInfo.setRoleid(1);

        User user = new User(userId, null, 1);

        userMapper.updateByPrimaryKeySelective(user);
        userInfoMapper.updateByPrimaryKeySelective(userInfo);

        return userInfo;
    }


}
