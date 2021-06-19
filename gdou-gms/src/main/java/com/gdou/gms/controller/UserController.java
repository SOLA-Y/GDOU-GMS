package com.gdou.gms.controller;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.gdou.gms.pojo.User;
import com.gdou.gms.pojo.UserInfo;
import com.gdou.gms.service.UserService;
import com.gdou.gms.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@CrossOrigin
@RestController
public class UserController
{
    @Autowired
    private HttpSession session;

    @Autowired
    private UserService userService;

    @GetMapping("/getMsg")
    public String getMsg()
    {
        return "你好";
    }

    // 验证token的有效性
    @GetMapping("/checkToken")
    public Boolean checkToken(HttpServletRequest request)
    {
        return JwtUtil.checkToken(request.getHeader("token"));
    }

    // 登录
    @PostMapping("/login")
    public Object login(@Validated @RequestBody User user)
    {
        // System.out.println(user);
        UserInfo userInfo = userService.login(user);

        // 登录成功
        if (userInfo != null)
        {
            JSONObject jsonObject = new JSONObject();
            String token = JwtUtil.createToken(userInfo);

            jsonObject.putOpt("userInfo", userInfo);
            jsonObject.putOpt("token", token);

            session.setAttribute("user", userInfo);
            // System.out.println("sessionId=" + session.getId());

            return jsonObject;
        }

        // 失败
        return null;
    }

    // 添加学生
    @PostMapping("/addUsers")
    public String addUsers(String jsonString, RedirectAttributes redirectAttributes)
    {
        List<UserInfo> userInfoList = JSONUtil.toList(jsonString, UserInfo.class);
        List<User> userList = JSONUtil.toList(jsonString, User.class);

        boolean add = userService.addUsers(userInfoList, userList);

        if (add)
        {
            redirectAttributes.addFlashAttribute("msg", "添加用户成功");
        }
        else
        {
            redirectAttributes.addFlashAttribute("msg", "添加用户失败");
        }

        return "redirect:/user_add";
    }

    // 添加管理员
    @PostMapping("/addAdmin")
    public String addAdministrator(String userId)
    {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserid(userId);
        userInfo.setRoleid(2);

        User user = new User();
        user.setUserid(userId);
        user.setRoleid(2);

        userService.addAdministrator(userInfo, user);

        return "redirect:/queryAllUsers";
    }

    // 更改密码
    @PostMapping("/updatePassword")
    public String updatePassword(String originalPassword, User user, Model model)
    {
        boolean update = userService.updatePassword(originalPassword, user);

        if (update)
        {
            model.addAttribute("msg", "密码修改成功");
        }
        else
        {
            model.addAttribute("msg", "原密码输入错误");
        }

        return "redirect:/queryUserInfo?userId=" + user.getUserid();

    }

    // 查询一个用户的信息
    @GetMapping("/queryUserInfo")
    public ModelAndView queryUserInfo(String userId)
    {
        UserInfo userInfo = userService.queryUserInfo(userId);
        ModelAndView mv = new ModelAndView();

        mv.addObject("userInfo", userInfo);
        mv.setViewName("user_query");

        return mv;

    }


}
