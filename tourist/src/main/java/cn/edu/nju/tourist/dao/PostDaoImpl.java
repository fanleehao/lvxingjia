package cn.edu.nju.tourist.dao;

import cn.edu.nju.tourist.bean.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fanleehao on 2019/1/15
 */

@Repository
public class PostDaoImpl implements PostDao {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public void addPost(Post post) {
        //获取用户，等其他信息

        String sql = "insert into post(post_title, post_context, post_time, post_images, post_location) " +
                "values(:post_title,:post_context, :post_time, :post_images, :post_location)";
        Map<String, Object> param = new HashMap<>();
        param.put("post_title", post.getPost_title());
        param.put("post_context", post.getPost_context());
        param.put("post_time", post.getPost_time());
        param.put("post_images", post.getPost_images());
        param.put("post_location", post.getPost_location());
        //System.out.println("success");
        jdbcTemplate.update(sql, param);
    }

    @Override
    public List<Post> findRecent() {
        String sql = "select * from post order by post_time desc limit 6";
        List<Post> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Post.class));
//        for (Post po: list ) {
//            System.out.println(po);
//        }
        return list;
    }

    @Override
    public Post findById(Integer id) {
        String sql = "select * from post where id = :id";
        Map<String,Object> map = new HashMap<>();
        map.put("id", id);
        Post post = jdbcTemplate.queryForObject(sql, map, new BeanPropertyRowMapper<Post>(Post.class));
        //System.out.println(post);
        return post;
    }

    @Override
    public void deleteById(Integer id) {
        String sql = "delete from post where id = :id";
        Map<String,Object> map = new HashMap<>();
        map.put("id", id);
        jdbcTemplate.update(sql, map);
    }

    @Override
    public List<Post> findAllPostsWithPage(int startIndex, int pageSize){
        String sql = "select * from post order by post_time desc limit :startIndex, :pageSize";
        Map<String,Object> map = new HashMap<>();
        map.put("startIndex", startIndex);
        map.put("pageSize", pageSize);


        List<Post> list = jdbcTemplate.query(sql, map, new BeanPropertyRowMapper<>(Post.class));
        return list;
    }

    @Override
    public int findAllRecords() {
        String sql = "select count(*) from post";
        return jdbcTemplate.queryForObject(sql, new HashMap<>(), Integer.class);
    }
}
