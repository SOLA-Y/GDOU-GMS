package com.gdou.gms.mapper;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.crypto.digest.Digester;
import com.gdou.gms.pojo.User;
import com.gdou.gms.pojo.UserInfo;
import com.gdou.gms.pojo.UserInfoExample;
import com.gdou.gms.util.Encrypt;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class UserInfoMapperTest
{
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    void testEncryptMD5()
    {
        System.out.println(Encrypt.encryptMD5("1234567890") + "，长度=" + Encrypt.encryptMD5("1234567890").length());

        System.out.println(DigestUtil.md5Hex("1234567890") + "，长度=" + DigestUtil.md5Hex("1234567890").length());

        System.out.println(DigestUtil.md5Hex(DigestUtil.md5Hex("1234567890")) + "，长度=" + DigestUtil.md5Hex(DigestUtil.md5Hex("1234567890")).length());

        Digester md5 = new Digester(DigestAlgorithm.MD5);
        // 加盐
        md5.setSalt("saltTest".getBytes());
        System.out.println(md5.digestHex("12345") + "，长度=" + md5.digestHex("12345").length());

    }

    @Test
    void testSelectByExample()
    {
        // 查询所有
        List<UserInfo> userInfoList = userInfoMapper.selectByExample(null);

        for (UserInfo userInfo : userInfoList)
        {
            System.out.println(userInfo);
        }
        System.out.println("----------------------------------------");

        // --------------------------------------------------------------------

        // 查询用户名中含有字母S并且性别为男的用户
        // 封装用户信息查询条件的example，用哪个mapper查询就使用哪个example
        UserInfoExample example = new UserInfoExample();
        // 创建Criteria，这个Criteria就是用来拼装查询条件
        UserInfoExample.Criteria criteria = example.createCriteria();
        // 用户名模糊查询，性别精确查询
        criteria.andUsernameLike("%S%");
        criteria.andGenderEqualTo("男");

        List<UserInfo> userInfoList1 = userInfoMapper.selectByExample(example);
        for (UserInfo userInfo : userInfoList1)
        {
            System.out.println(userInfo);
        }
        System.out.println("----------------------------------------");

    }

    @Test
    void testDeleteByPrimaryKey()
    {
        int i = userInfoMapper.deleteByPrimaryKey("201811701300");
        System.out.println("影响行数：" + i);
    }

    @Test
    void testInsert()
    {
        String password1 = Encrypt.encryptMD5("0123456789");
        // int i1 = userInfoMapper.insert(new UserInfo("201811701308", password1, "志宏", "男", "1234567@qq.com", "14770697894", 3));
        // System.out.println("影响行数：" + i1);
        //
        // String password2 = Encrypt.encryptMD5("0123456789");
        // int i2 = userInfoMapper.insert(new UserInfo("201811701309", password2, "敏玲", "女", "12345678@qq.com", "14770697893", 3));
        // System.out.println("影响行数：" + i2);
        //
        // String password3 = Encrypt.encryptMD5("0123456789");
        // int i3 = userInfoMapper.insert(new UserInfo("201811701310", password3, "文琪", "女", "123456789@qq.com", "14770697892", 3));
        // System.out.println("影响行数：" + i3);

        userMapper.insert(new User("201811701308", password1, 3));
        userMapper.insert(new User("201811701309", password1, 3));
        userMapper.insert(new User("201811701310", password1, 3));

    }

    @Test
    void updateByPrimaryKeySelective()
    {
        int i = userInfoMapper.updateByPrimaryKeySelective(new UserInfo("201811701307", "阿生", null, null, null, null));
        System.out.println("影响行数：" + i);
    }


}