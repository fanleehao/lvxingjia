package cn.edu.nju.tourist.controller;

import cn.edu.nju.tourist.bean.Post;
import cn.edu.nju.tourist.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author fanleehao on 2019/1/15
 */

@Controller
public class Postcontroller {

    @Autowired
    private PostService postService;

    @GetMapping("/post")
    public String PostUI(){
        return "addpost";
    }

    @PostMapping("/post")
    public String addPost(Post post){

        System.out.println(post);
        postService.addPost(post);
        //重定向到首页
        return "redirect:/index2";
    }

    //查看页
    @GetMapping("/single/{id}")
    public String contextUI(@PathVariable("id") Integer id, Model model){
        Post post = postService.findById(id);
        //添加到模型
        model.addAttribute("post", post);
        return "single";
    }

}
