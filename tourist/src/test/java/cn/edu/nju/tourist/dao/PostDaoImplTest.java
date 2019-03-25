package cn.edu.nju.tourist.dao;

import cn.edu.nju.tourist.bean.Post;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class PostDaoImplTest {

    @Autowired
    private PostDao postDao;
    
    @Before
    public void setUp() throws Exception {
        //postDao = new PostDaoImpl();
    }

    @Test
    public void addPost() {

    }

    @Test
    public void findRecnet() {
        List<Post> recnet = postDao.findRecent();
       for (Post post : recnet) {
           System.out.println(post);
       }
    }

    @Test
    public void findById() {
        Post post = postDao.findById(2);
        System.out.println(post);
    }

    @Test
    public void findAllRecords() {
        int size = postDao.findAllRecords();
        System.out.println("size:" + size);
    }

    @Test
    public void findAllPostsWithPage() {
        List<Post> list = postDao.findAllPostsWithPage(0, 6);
        for (Post p : list) {
            System.out.println(p);
        }

    }
}