package com.gdou.gms.controller;

import cn.hutool.json.JSONObject;
import com.gdou.gms.pojo.Condition;
import com.gdou.gms.pojo.User;
import com.gdou.gms.pojo.UserInfo;
import com.gdou.gms.service.MailService;
import com.gdou.gms.service.UserService;
import com.gdou.gms.util.JwtUtil;
import com.gdou.gms.util.RandomCharUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
public class UserController
{

    @Autowired
    private UserService userService;

    @Autowired
    private MailService mailService;

    private String validateCode;

    private Date sendTime;

    // 登录
    @PostMapping("/login")
    public Object login(@Validated @RequestBody User user, BindingResult bindingResult)
    {
        JSONObject jsonObject = new JSONObject();

        // System.out.println(user);
        // 判断校验是否通过，如果不通过会有错误消息
        if (bindingResult.hasErrors())
        {
            // 获取所有错误消息
            List<FieldError> errors = bindingResult.getFieldErrors();

            for (FieldError error : errors)
            {
                jsonObject.putOpt(error.getField(), error.getDefaultMessage());
            }

            return jsonObject;
        }

        UserInfo userInfo = userService.login(user);

        // 登录成功
        if (userInfo != null)
        {
            String token = JwtUtil.createToken(userInfo);

            jsonObject.putOpt("userInfo", userInfo);
            jsonObject.putOpt("token", token);
        }
        else
        {
            // 登录失败
            jsonObject.putOpt("loginMessage", "账号或密码错误");
        }

        return jsonObject;
    }

    // 添加普通用户，返回添加用户数量，-1表示添加失败
    @GetMapping("/addUsers")
    public Integer addUsers(@RequestParam("jsonString") String jsonString)
    {
        return userService.addUsers(jsonString);
    }

    // 设置管理员权限
    @GetMapping("/setAdmin")
    public Boolean setAdministrator(@RequestParam("userId") String userId)
    {
        try
        {
            UserInfo userInfo = userService.setAdministrator(userId);
            mailService.sendSetMail(userInfo);
            return true;
        } catch (Exception e)
        {
            return false;
        }

    }

    // 更新密码
    @GetMapping("/updatePassword")
    public Boolean updatePassword(@RequestParam("originalPwd") String originalPwd, @RequestParam("userId") String userId, @RequestParam("newPwd") String newPwd)
    {
        User user = new User(userId, newPwd, null);
        return userService.updatePassword(originalPwd, user);
    }

    // 用户自己更新本人信息
    @GetMapping("/updateUserInfoBySelf")
    public Object updateUserInfoBySelf(@RequestParam("userId") String userId, @RequestParam("mail") String mail, @RequestParam("phone") String phone, @RequestParam("code") String code)
    {
        if (RandomCharUtil.getMinute(sendTime, new Date()) > 10)
        {
            // 验证码失效
            return "invalid";
        }
        if (!validateCode.equals(code))
        {
            // 验证码错误
            return "error";
        }

        UserInfo userInfo = new UserInfo(userId, null, null, mail, phone, null);

        return userService.updateUserInfo(userInfo);
    }

    // 管理员更新用户信息
    @PostMapping("/updateUserInfoByAdmin")
    public Boolean updateUserInfoByAdmin(@RequestBody UserInfo userInfo)
    {
        return userService.updateUserInfo(userInfo);
    }

    // 发送验证码邮件
    @PostMapping("/sendValidateCodeMail")
    public Boolean sendValidateCodeMail(@RequestBody UserInfo userInfo)
    {
        validateCode = RandomCharUtil.createValidateCode();
        sendTime = new Date();

        return mailService.sendValidateCodeMail(userInfo, validateCode, sendTime);
    }

    // 查询一个用户的信息
    @GetMapping("/queryUserInfo")
    public UserInfo queryUserInfo(@RequestParam("userId") String userId)
    {
        return userService.queryUserInfo(userId);
    }

    // 查询所有用户
    @GetMapping("/queryAllUsers")
    public List<UserInfo> queryUserInfo()
    {
        return userService.queryAllUsers();
    }

    // 根据条件查询用户
    @PostMapping("/queryUsersByCondition")
    public List<UserInfo> queryUsersByCondition(@RequestBody Condition condition)
    {
        return userService.queryUsersByCondition(condition);
    }

    // 删除用户
    @GetMapping("/deleteUser")
    public Boolean deleteUser(@RequestParam("userId") String userId)
    {
        return userService.deleteUser(userId);
    }

    // 移除管理员权限
    @GetMapping("/removeAdmin")
    public Boolean removeAdministrator(@RequestParam("userId") String userId)
    {
        try
        {
            UserInfo userInfo = userService.removeAdministrator(userId);
            mailService.sendRemoveMail(userInfo);
            return true;
        } catch (Exception e)
        {
            return false;
        }

    }

}
