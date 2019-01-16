package cn.edu.nju.tourist.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/authority")
public class AuthorityController {
    @RequestMapping("/signIn")
    public String signIn(@RequestParam("name") String name, @RequestParam("password") String password, Model model) {
        System.out.println("--------" + name);
        // 使用shiro编写认证操作
        // 1.获取Subject
        Subject subject = SecurityUtils.getSubject();

        // 2. 封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(name, password);

        // 3.执行登录方法
        try {
            // 登录成功
            subject.login(token);
            model.addAttribute("msg", "登录成功");
        } catch (UnknownAccountException e) {
            // 用户名不存在
            model.addAttribute("msg", "用户名不存在");
        } catch (IncorrectCredentialsException e) {
            model.addAttribute("msg", "密码错误");
        }
        return "success";
    }

    @RequestMapping("/toSignIn")
    public String toSignIn() {
        return "/signin";
    }

    @RequestMapping("/toSignUp")
    public String signUp() {
        return "test";
    }

    @RequestMapping("/toIndex")
    public String toIndex() {
        return "index";
    }

    /**
     * 认证被拦截后的跳转
     *
     * @return 返回拦截的页面
     */
    @RequestMapping("/authcFail")
    public String authenticationFailure(Model model) {
        model.addAttribute("msg", "您尚未登录，不能访问该页面");
        return "forbidden";
    }

    /**
     * 未授权页面的跳转
     */
    @RequestMapping("/noAuthc")
    public String noAuthentication(Model model) {
        model.addAttribute("msg", "您没有权限访问该页面");
        return "forbidden";
    }
}
