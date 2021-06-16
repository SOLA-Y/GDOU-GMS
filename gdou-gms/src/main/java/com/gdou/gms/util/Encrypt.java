package com.gdou.gms.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encrypt
{
    // MD5加密算法
    public static String encryptMD5(String strSrc)
    {
        // md为加密类实例
        MessageDigest md = null;
        // strDes为密文
        String strDes = null;

        try
        {
            // 获取MD5加密实例
            md = MessageDigest.getInstance("MD5");
            // 封装明文，得到字节数组的加密对象，MD5只对字节数组进行加密计算
            md.update(strSrc.getBytes());
            // 进行加密运算，返回密文的字节数组bt
            byte[] bt = md.digest();
            // 将字节数组转换成十六进制字符串，形成最终的密文
            strDes = bytesToHex(bt);
        } catch (NoSuchAlgorithmException e)
        {
            System.out.println("Invalid algorithm.");
            return null;
        }
        return strDes;
    }

    // 转十六进制字符串
    public static String bytesToHex(byte[] bts)
    {
        String des = "";
        String tmp = null;
        for (int i = 0; i < bts.length; i++)
        {
            // 转十六进制字符
            tmp = Integer.toHexString(bts[i] & 0xFF);
            if (tmp.length() == 1)
            {
                des = des + "0";
            }
            des = des + tmp;
        }

        return des;
    }


}
