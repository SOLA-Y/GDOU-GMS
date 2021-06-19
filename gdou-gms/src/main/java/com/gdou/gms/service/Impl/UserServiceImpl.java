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
    @Override
    @Transactional
    public Boolean setAdministrator(String userId)
    {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserid(userId);
        userInfo.setRoleid(2);

        User user = new User();
        user.setUserid(userId);
        user.setRoleid(2);

        int update1 = userInfoMapper.updateByPrimaryKeySelective(userInfo);
        int update2 = userMapper.updateByPrimaryKeySelective(user);

        return update1 == update2 && update1 != 0;
    }

    @Override
    @Transactional
    public Integer addUsers(String jsonString)
    {
        int insert1 = 0;
        int insert2 = 0;

        List<UserInfo> userInfoList = JSONUtil.toList(jsonString, UserInfo.class);
        List<User> userList = JSONUtil.toList(jsonString, User.class);

        for (UserInfo userInfo : userInfoList)
        {
            // 查询到的用户不存在才插入到表中
            if (userInfoMapper.selectByPrimaryKey(userInfo.getUserid()) == null)
            {
                insert1 += userInfoMapper.insert(userInfo);
            }
        }

        for (User user : userList)
        {
            if (userMapper.selectByPrimaryKey(user.getUserid()) == null)
            {
                user.setPassword(DigestUtil.md5Hex(user.getPassword()));
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
        UserInfoExample example = ExampleUtil.createUserInfoExample(condition);
        return userInfoMapper.selectByExample(example);
    }

    @Override
    public Boolean deleteUser(String userId)
    {
        int delete1 = userMapper.deleteByPrimaryKey(userId);
        int delete2 = userInfoMapper.deleteByPrimaryKey(userId);

        return delete1 == 1 && delete2 == 1;
    }

    @Override
    public Boolean removeAdministrator(String userId)
    {
        User user = new User(userId, null, 1);
        UserInfo userInfo = new UserInfo();
        userInfo.setUserid(userId);
        userInfo.setRoleid(1);

        int update1 = userMapper.updateByPrimaryKeySelective(user);
        int update2 = userInfoMapper.updateByPrimaryKeySelective(userInfo);

        return update1 == 1 && update2 == 1;
    }


}
