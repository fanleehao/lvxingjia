package cn.edu.nju.tourist.service;

import cn.edu.nju.tourist.bean.PageModel;
import cn.edu.nju.tourist.bean.Post;
import cn.edu.nju.tourist.dao.PostDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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
        Date current = new Date();
        post.setPost_time(current);
        post.setPost_images("image/default.jpg");
        //System.out.println("fanleehao:" + post);
        postDao.addPost(post);
    }

    @Override
    public List<Post> findRecent() {
        return postDao.findRecent();
    }

    @Override
    public Post findById(Integer id) {
        return postDao.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        postDao.deleteById(id);
    }

    @Override
    public PageModel findAllWithPages(int curPageNum, int pageSize) {
        //1.构造对象
        int totalRecords = postDao.findAllRecords();
        PageModel pageModel = new PageModel(curPageNum, totalRecords, pageSize);
        //2.关联集合
        List<Post> list = postDao.findAllPostsWithPage(pageModel.getStartIndex(), pageModel.getPageSize());
        pageModel.setList(list);
        //3.关联URL
        pageModel.setUrl("/indexAll");
        return pageModel;


    }
}
