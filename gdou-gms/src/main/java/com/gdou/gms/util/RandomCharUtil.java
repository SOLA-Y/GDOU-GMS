package com.gdou.gms.util;

import cn.hutool.core.util.RandomUtil;

import java.util.Date;

public class RandomCharUtil
{

    // 随机生成6位验证码
    public static String createValidateCode()
    {
        String validateCode = "";

        for (int i = 0; i < 666; i++)
        {
            String code = String.valueOf(RandomUtil.randomChar());

            if (!validateCode.contains(code))
            {
                validateCode += code;

                if (validateCode.length() == 6)
                {
                    break;
                }
            }
        }

        return validateCode;
    }

    public static int getMinute(Date startTime, Date endTime)
    {
        return (int) ((startTime.getTime() - endTime.getTime()) / (60 * 1000));
    }

}
