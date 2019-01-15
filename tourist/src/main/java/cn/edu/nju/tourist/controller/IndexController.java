package cn.edu.nju.tourist.controller;

import cn.edu.nju.tourist.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * 主页显示
 *
 * @author fanleehao on 2019/1/14
 */

@Controller
public class IndexController {

    @RequestMapping("/index2")
    public String success(Map<Object, Object> map){
        //拼接后classpath:templates/success.html转到
//        User user = new User();
//        user.setUserName("张三");
        map.put("hello","张三");
        return "index2";
    }
}
