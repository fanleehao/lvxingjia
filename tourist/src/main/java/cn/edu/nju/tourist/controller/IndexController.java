package cn.edu.nju.tourist.controller;

import cn.edu.nju.tourist.bean.PageModel;
import cn.edu.nju.tourist.bean.Post;
import cn.edu.nju.tourist.bean.User;
import cn.edu.nju.tourist.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * 主页显示
 *
 * @author fanleehao on 2019/1/14
 */

@Controller
public class IndexController {
    @Autowired
    private PostService postService;

    @RequestMapping("/index2")
    public String success(Map<Object, Object> map){
        //拼接后classpath:templates/success.html转到
//        User user = new User();
//        user.setUserName("张三");
        //查询最近的文章
        List<Post> list =  postService.findRecent();

        map.put("list", list);
        return "index2";
    }

    @RequestMapping("/indexAll/{num}")
    public String findAll(Map<Object, Object> map, @PathVariable("num") Integer num){
        //带分页的显示
        //参数
        int curPageNum = num;
        int pageSize = 6;
        PageModel pageModel = postService.findAllWithPages(curPageNum, pageSize);

        map.put("pageModel", pageModel);
        //System.out.println(pageModel.getStartPage());
        return "index3";
    }
}
