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

        String sql = "insert into post(post_title, post_context) values(:post_title,:post_context)";
        Map<String, Object> param = new HashMap<>();
        param.put("post_title", post.getPost_title());
        param.put("post_context", post.getPost_context());
        System.out.println("success");
        jdbcTemplate.update(sql, param);
    }

    @Override
    public List<Post> findRecnet() {
        String sql = "select * from post order by post_time desc limit 6";
        List<Post> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Post.class));
        for (Post po: list ) {
            System.out.println(po);
        }
        return list;
    }
}
