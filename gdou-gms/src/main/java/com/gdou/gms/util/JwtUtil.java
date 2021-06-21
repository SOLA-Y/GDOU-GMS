package com.gdou.gms.util;

import cn.hutool.core.lang.UUID;
import com.gdou.gms.pojo.UserInfo;
import io.jsonwebtoken.*;

import java.util.Date;

public class JwtUtil
{
    // 有效时间是一天
    private static long time = 1000 * 60 * 60 * 24;
    // 签名信息，通过这个进行加密或解密
    private static String signature = "gdou-gms";

    // 创建token
    public static String createToken(UserInfo userInfo)
    {
        // 创建jwt，最后用compact()方法进行拼接
        JwtBuilder jwtBuilder = Jwts.builder();

        return jwtBuilder
                // Header头部信息
                .setHeaderParam("type", "JWT")
                .setHeaderParam("alg", "HS256")
                // Payload载荷（用户信息、主题、有效时间、jwt的id）
                .claim("userId", userInfo.getUserid())
                .claim("roleId", userInfo.getRoleid())
                .setSubject("gms-login-test")
                .setExpiration(new Date(System.currentTimeMillis() + time))
                .setId(UUID.randomUUID().toString())
                // Signature签名（加密算法）
                .signWith(SignatureAlgorithm.HS256, signature)
                .compact();

    }

    // 解析token
    public void parseToken(String token)
    {
        JwtParser jwtParser = Jwts.parser();
        // 解析成很多个claim
        Jws<Claims> claimsJws = jwtParser.setSigningKey(signature).parseClaimsJws(token);
        Claims claims = claimsJws.getBody();
        System.out.println(claims.get("username"));
        System.out.println(claims.get("roleId"));
        System.out.println(claims.getId());
        System.out.println(claims.getSubject());
        System.out.println(claims.getExpiration());
    }

    // 判断token的有效性
    public static boolean checkToken(String token)
    {
        if (token == null || token.equals(""))
        {
            return false;
        }

        try
        {
            // 判断这个解析操作是否正常，如果正常则说明token有效，抛异常则说明token失效
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(signature).parseClaimsJws(token);
        } catch (Exception e)
        {
            return false;
        }

        return true;
    }

}
