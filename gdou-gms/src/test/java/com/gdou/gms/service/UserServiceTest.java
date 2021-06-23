package com.gdou.gms.service;

import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.json.JSONUtil;
import com.gdou.gms.pojo.User;
import com.gdou.gms.pojo.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class UserServiceTest
{
    @Autowired
    private UserService userService;

    @Test
    void updateUser()
    {
        String password = DigestUtil.md5Hex("1234567890");

        UserInfo userInfo = new UserInfo();
        userInfo.setUserid("201811701307");
        // userInfo.setMail("12296@qq.com");

        // 1234567890：e807f1fcf82d132f9bb018ca6738a19f
        // 123456789：25f9e794323b453885f5181f1b624d0b

        User user = new User(userInfo.getUserid() + "2", password, null);

        // userService.updateUser(userInfo, user);

    }

    @Test
    void addUsers()
    {
        String jsonString = "[{\"userid\":\"201811701315\",\"username\":\"白橡\",\"gender\":\"男\",\"mail\":\"2214253@qq.com\",\"phone\":\"14787654321\"},{\"userid\":\"201811701316\",\"username\":\"桔梗\",\"gender\":\"女\",\"mail\":\"1241255@qq.com\",\"phone\":\"14787654321\"},{\"userid\":\"201811701317\",\"username\":\"伽罗\",\"gender\":\"男\",\"mail\":\"1241255@qq.com\",\"phone\":\"14787654321\"},{\"userid\":\"201811701318\",\"username\":\"丹青\",\"gender\":\"男\",\"mail\":\"1241255@qq.com\",\"phone\":\"14787654321\"},{\"userid\":\"201811701319\",\"username\":\"瑠璃\",\"gender\":\"女\",\"mail\":\"1241255@qq.com\",\"phone\":\"14787654321\"},{\"userid\":\"201811701320\",\"username\":\"蔷薇\",\"gender\":\"女\",\"mail\":\"1241255@qq.com\",\"phone\":\"14787654321\"},{\"userid\":\"201811701321\",\"username\":\"珊瑚\",\"gender\":\"女\",\"mail\":\"1241255@qq.com\",\"phone\":\"14787654321\"},{\"userid\":\"201811701322\",\"username\":\"桦茶\",\"gender\":\"男\",\"mail\":\"1241255@qq.com\",\"phone\":\"14787654321\"},{\"userid\":\"201811701323\",\"username\":\"媚茶\",\"gender\":\"女\",\"mail\":\"1241255@qq.com\",\"phone\":\"14787654321\"},{\"userid\":\"201811701324\",\"username\":\"杜若\",\"gender\":\"男\",\"mail\":\"1241255@qq.com\",\"phone\":\"14787654321\"},{\"userid\":\"201811701325\",\"username\":\"薄柿\",\"gender\":\"男\",\"mail\":\"1241255@qq.com\",\"phone\":\"14787654321\"},{\"userid\":\"201811701326\",\"username\":\"柑子\",\"gender\":\"女\",\"mail\":\"1241255@qq.com\",\"phone\":\"14787654321\"},{\"userid\":\"201811701327\",\"username\":\"抹茶\",\"gender\":\"女\",\"mail\":\"1241255@qq.com\",\"phone\":\"14787654321\"},{\"userid\":\"201811701328\",\"username\":\"蜜柑\",\"gender\":\"女\",\"mail\":\"1241255@qq.com\",\"phone\":\"14787654321\"},{\"userid\":\"201811701329\",\"username\":\"若草\",\"gender\":\"女\",\"mail\":\"1241255@qq.com\",\"phone\":\"14787654321\"},{\"userid\":\"201811701330\",\"username\":\"赤丹\",\"gender\":\"男\",\"mail\":\"1241255@qq.com\",\"phone\":\"14787654321\"},{\"userid\":\"201811701331\",\"username\":\"褐返\",\"gender\":\"男\",\"mail\":\"1241255@qq.com\",\"phone\":\"14787654321\"},{\"userid\":\"201811701332\",\"username\":\"绀蓝\",\"gender\":\"男\",\"mail\":\"1241255@qq.com\",\"phone\":\"14787654321\"},{\"userid\":\"201811701333\",\"username\":\"苏芳\",\"gender\":\"女\",\"mail\":\"1241255@qq.com\",\"phone\":\"14787654321\"},{\"userid\":\"201811701334\",\"username\":\"鸠羽\",\"gender\":\"男\",\"mail\":\"1241255@qq.com\",\"phone\":\"14787654321\"},{\"userid\":\"201811701335\",\"username\":\"千草\",\"gender\":\"女\",\"mail\":\"1241255@qq.com\",\"phone\":\"14787654321\"},{\"userid\":\"201811701336\",\"username\":\"银朱\",\"gender\":\"男\",\"mail\":\"1241255@qq.com\",\"phone\":\"14787654321\"},{\"userid\":\"201811701337\",\"username\":\"胡桃\",\"gender\":\"女\",\"mail\":\"1241255@qq.com\",\"phone\":\"14787654321\"},{\"userid\":\"201811701338\",\"username\":\"江户\",\"gender\":\"男\",\"mail\":\"1241255@qq.com\",\"phone\":\"14787654321\"},{\"userid\":\"201811701339\",\"username\":\"绯红\",\"gender\":\"女\",\"mail\":\"1241255@qq.com\",\"phone\":\"14787654321\"},{\"userid\":\"201811701340\",\"username\":\"琥珀\",\"gender\":\"女\",\"mail\":\"1241255@qq.com\",\"phone\":\"14787654321\"},{\"userid\":\"201811701341\",\"username\":\"葡萄\",\"gender\":\"男\",\"mail\":\"1241255@qq.com\",\"phone\":\"14787654321\"},{\"userid\":\"201811701342\",\"username\":\"栀子\",\"gender\":\"男\",\"mail\":\"1241255@qq.com\",\"phone\":\"14787654321\"},{\"userid\":\"201811701343\",\"username\":\"麹尘\",\"gender\":\"女\",\"mail\":\"1241255@qq.com\",\"phone\":\"14787654321\"},{\"userid\":\"201811701344\",\"username\":\"萱草\",\"gender\":\"女\",\"mail\":\"1241255@qq.com\",\"phone\":\"14787654321\"},{\"userid\":\"201811701345\",\"username\":\"若竹\",\"gender\":\"男\",\"mail\":\"1241255@qq.com\",\"phone\":\"14787654321\"},{\"userid\":\"201811701346\",\"username\":\"牡丹\",\"gender\":\"女\",\"mail\":\"1241255@qq.com\",\"phone\":\"14787654321\"},{\"userid\":\"201811701347\",\"username\":\"深绯\",\"gender\":\"女\",\"mail\":\"1241255@qq.com\",\"phone\":\"14787654321\"},{\"userid\":\"201811701348\",\"username\":\"浅葱\",\"gender\":\"女\",\"mail\":\"1241255@qq.com\",\"phone\":\"14787654321\"},{\"userid\":\"201811701349\",\"username\":\"勿忘\",\"gender\":\"男\",\"mail\":\"1241255@qq.com\",\"phone\":\"14787654321\"},{\"userid\":\"201811701350\",\"username\":\"樱草\",\"gender\":\"女\",\"mail\":\"1241255@qq.com\",\"phone\":\"14787654321\"},{\"userid\":\"201811701351\",\"username\":\"丁香\",\"gender\":\"女\",\"mail\":\"1241255@qq.com\",\"phone\":\"14787654321\"},{\"userid\":\"201811701352\",\"username\":\"藕荷\",\"gender\":\"女\",\"mail\":\"1241255@qq.com\",\"phone\":\"14787654321\"},{\"userid\":\"201811701353\",\"username\":\"海棠\",\"gender\":\"男\",\"mail\":\"1241255@qq.com\",\"phone\":\"14787654321\"},{\"userid\":\"201811701354\",\"username\":\"胭脂\",\"gender\":\"女\",\"mail\":\"1241255@qq.com\",\"phone\":\"14787654321\"},{\"userid\":\"201811701355\",\"username\":\"葱倩\",\"gender\":\"女\",\"mail\":\"1241255@qq.com\",\"phone\":\"14787654321\"},{\"userid\":\"201811701356\",\"username\":\"翡翠\",\"gender\":\"女\",\"mail\":\"1241255@qq.com\",\"phone\":\"14787654321\"},{\"userid\":\"201811701357\",\"username\":\"石榴\",\"gender\":\"女\",\"mail\":\"1241255@qq.com\",\"phone\":\"14787654321\"}]";

        List<UserInfo> userInfoList = JSONUtil.toList(jsonString, UserInfo.class);

        for (UserInfo userInfo : userInfoList)
        {
            if (true)
            {
                userInfo.setRoleid(1);
                String password = DigestUtil.md5Hex(userInfo.getUserid());
                User user = new User(userInfo.getUserid(), password, 1);
                System.out.println(userInfo);
                System.out.println(user);
                System.out.println("-----------------------------------------------------------");
            }
        }

    }
}