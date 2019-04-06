package cn.edu.nju.tourist.service;

import cn.edu.nju.tourist.bean.Post;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class PostServiceImplTest {

    @Autowired
    private PostService postService;

    private Post post;
    private Date curDate;

    @Before
    public void setUp() throws Exception {
        //postService = new PostServiceImpl();
        post = new Post();
    }

    @Test
    public void addPost() {
//        curDate = new Date();
//        post.setPost_time(curDate);
//        System.out.println(curDate);
//        post.setId(13);
        post.setPost_title("你好，霓虹！");
//        postService.addPost(post);
    }

    @Test
    public void findRecent() {
        List<Post> recent = postService.findRecent();
        for (Post post: recent) {
            System.out.println(post);
        }
    }

    @Test
    public void findById() {
        Post p = postService.findById(2);
        System.out.println(p);
    }

    @Test
    public void deleteBtId(){
//        postService.findById(14);
        postService.deleteById(14);
    }


}