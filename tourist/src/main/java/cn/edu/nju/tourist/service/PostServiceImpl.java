package cn.edu.nju.tourist.service;

import cn.edu.nju.tourist.bean.Post;
import cn.edu.nju.tourist.dao.PostDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * PostServiceImpl
 *
 * @author fanleehao on 2019/1/15
 */

@Service
public class PostServiceImpl implements PostService{
    @Autowired
    private PostDao postDao;

    @Override
    public void addPost(Post post) {
        postDao.addPost(post);
    }
}
