package com.gdou.gms.mapper;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.crypto.digest.Digester;
import com.gdou.gms.pojo.User;
import com.gdou.gms.pojo.UserInfo;
import com.gdou.gms.pojo.UserInfoExample;
import com.gdou.gms.util.JwtUtil;
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

        System.out.println(DigestUtil.md5Hex("1234567890") + "，长度=" + DigestUtil.md5Hex("1234567890").length());

        System.out.println(DigestUtil.md5Hex(DigestUtil.md5Hex("1234567890")) + "，长度=" + DigestUtil.md5Hex(DigestUtil.md5Hex("1234567890")).length());

        Digester md5 = new Digester(DigestAlgorithm.MD5);
        // 加盐
        md5.setSalt("saltTest".getBytes());
        System.out.println(md5.digestHex("12345") + "，长度=" + md5.digestHex("12345").length());

    }

    @Test
    void testToken()
    {
        JwtUtil jwtUtil = new JwtUtil();
        String token = jwtUtil.createToken(new UserInfo("201820182018", null, null, null, null, 3));

        System.out.println(token);

        jwtUtil.parseToken(token);

        System.out.println(StrUtil.isNotBlank(""));
        System.out.println(StrUtil.isNotBlank(null));
        System.out.println(StrUtil.isNotBlank("   234   "));
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
        criteria.andUsernameLike("%生%");
        criteria.andGenderEqualTo("男");

        List<UserInfo> userInfoList1 = userInfoMapper.selectByExample(example);
        for (UserInfo userInfo : userInfoList1)
        {
            System.out.println(userInfo);
        }
        System.out.println("----------------------------------------");


        UserInfoExample example1 = new UserInfoExample();
        UserInfoExample.Criteria criteria1 = example1.createCriteria();
        // criteria1.andGenderEqualTo(null);

        for (UserInfo userInfo : userInfoMapper.selectByExample(example1))
        {
            System.out.println(userInfo);
        }

    }

    @Test
    void testDeleteByPrimaryKey()
    {
        int i = userInfoMapper.deleteByPrimaryKey("201820182018");
        System.out.println("影响行数：" + i);
    }

    @Test
    void testInsert()
    {
        String password1 = DigestUtil.md5Hex("0123456789");
        // int i1 = userInfoMapper.insert(new UserInfo("201820182018", password1, "小宏", "男", "1234567@qq.com", "14770697894", 3));
        // System.out.println("影响行数：" + i1);
        //
        // String password2 = Encrypt.encryptMD5("0123456789");
        // int i2 = userInfoMapper.insert(new UserInfo("201820182019", password2, "小敏", "女", "12345678@qq.com", "14770697893", 3));
        // System.out.println("影响行数：" + i2);
        //
        // String password3 = Encrypt.encryptMD5("0123456789");
        // int i3 = userInfoMapper.insert(new UserInfo("201820182020", password3, "小琪", "女", "123456789@qq.com", "14770697892", 3));
        // System.out.println("影响行数：" + i3);

        userMapper.insert(new User("201820182018", password1, 3));
        userMapper.insert(new User("201820182019", password1, 3));
        userMapper.insert(new User("201820182020", password1, 3));

    }

    @Test
    void updateByPrimaryKeySelective()
    {
        int i = userInfoMapper.updateByPrimaryKeySelective(new UserInfo("201820182018", "小生", null, null, null, null));
        System.out.println("影响行数：" + i);
    }


}