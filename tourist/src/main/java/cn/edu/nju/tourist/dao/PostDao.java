package cn.edu.nju.tourist.dao;

import cn.edu.nju.tourist.bean.Post;

import java.util.List;

public interface PostDao {
    public void addPost(Post post);

    List<Post> findRecnet();

    Post findById(Integer id);
}
