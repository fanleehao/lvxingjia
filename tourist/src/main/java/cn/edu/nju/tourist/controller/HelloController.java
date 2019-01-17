package cn.edu.nju.tourist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "index";
    }

    @RequestMapping("/success")
    @ResponseBody
    public String success(Map<String,String> map){
        map.put("Success","成功");
        return "success";
    }
}
