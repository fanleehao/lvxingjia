package cn.edu.nju.tourist.mapper;

import cn.edu.nju.tourist.bean.Post;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PostMapper {
    @Select("SELECT * FROM user")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "post_title", column = "post_title"),
            @Result(property = "post_context", column = "post_context"),
            @Result(property = "post_time", column = "post_time"),
            @Result(property = "post_last_edit", column = "post_last_edit"),
            @Result(property = "post_images", column = "post_images"),
            @Result(property = "post_location", column = "post_location"),
            @Result(property = "user_name", column = "user_name"),
    })
    List<Post> getAllPosts();

}
