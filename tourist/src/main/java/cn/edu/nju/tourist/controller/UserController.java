package cn.edu.nju.tourist.controller;

import cn.edu.nju.tourist.bean.User;
import cn.edu.nju.tourist.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getAll")
    @ResponseBody
    public List<User> getUsers() {
        System.out.println("--------");
        System.out.println(userService.getAllUsers() + ".......");
        for (int i = 0; i < userService.getAllUsers().size(); i++) {
            System.out.println(userService.getAllUsers().get(i));
        }
        return userService.getAllUsers();
    }

    /**
     * 测试thymeleaf
     */
    @RequestMapping("/testThymeleaf")
    public String testThymeleaf(Model model) {
        model.addAttribute("name", "hello");
        return "test";
    }

    /**
     * 测试认证资源拦截
     *
     * @return 返回用户登录后的页面（个人信息）
     */
    @RequestMapping("/info")
    public String testIndentity() {
        return "/user/info";
    }




}
