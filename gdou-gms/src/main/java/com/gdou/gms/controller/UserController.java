package com.gdou.gms.controller;

import cn.hutool.json.JSONUtil;
import com.gdou.gms.pojo.User;
import com.gdou.gms.pojo.UserInfo;
import com.gdou.gms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController
{

    @Autowired
    private UserService userService;

    @GetMapping("/getMsg")
    @ResponseBody
    public String getMsg()
    {
        return "你好";
    }

    // 跳转到登录页面
    @GetMapping(value = {"/", "/login"})
    public String loginPage()
    {
        return "login";
    }

    // 跳转到添加用户页面
    @GetMapping("/user_add")
    public ModelAndView userAddPage(@ModelAttribute("msg") String msg)
    {
        ModelAndView mv = new ModelAndView();

        mv.addObject("msg", msg);
        mv.setViewName("user_add");

        return mv;
    }

    // 登录
    @PostMapping("/login")
    public String login(User user, HttpSession session, Model model)
    {
        User loginUser = userService.login(user);
        if (loginUser != null)
        {
            // 登录成功
            session.setAttribute("user", loginUser);
            return "index";
        }
        else
        {
            // 失败
            model.addAttribute("msg", "账号或密码错误");
            return "login";
        }
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
