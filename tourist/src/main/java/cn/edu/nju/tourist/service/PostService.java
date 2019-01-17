package cn.edu.nju.tourist.service;

import cn.edu.nju.tourist.bean.Post;

import java.util.List;

public interface PostService {
    //
    public void addPost(Post post);

    List<Post> findRecent();

    Post findById(Integer id);
}
