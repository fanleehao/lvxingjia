package cn.edu.nju.tourist.dao;

import cn.edu.nju.tourist.bean.Post;

import java.util.List;

public interface PostDao {
    public void addPost(Post post);

    List<Post> findRecent();

    Post findById(Integer id);

    void deleteById(Integer id);

    int findAllRecords();

    List<Post> findAllPostsWithPage(int startIndex, int pageSize);
}
