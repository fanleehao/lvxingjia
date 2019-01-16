package cn.edu.nju.tourist.mapper;

import cn.edu.nju.tourist.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user")
    @Results({
            @Result(property = "userId", column = "id"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "password", column = "user_password"),
            @Result(property = "gender", column = "user_gender"),
            @Result(property = "email", column = "user_email"),
            @Result(property = "phone", column = "user_phone"),
            @Result(property = "age", column = "user_age"),
            @Result(property = "birthday", column = "user_birthday"),
            @Result(property = "registerTime", column = "regist_time"),
            @Result(property = "sign", column = "user_sign")
    })
    List<User> getAllUsers();

    @Select("SELECT * FROM user WHERE user_name=#{name}")
    @Results({
            @Result(property = "userId", column = "id"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "password", column = "user_password"),
            @Result(property = "gender", column = "user_gender"),
            @Result(property = "email", column = "user_email"),
            @Result(property = "phone", column = "user_phone"),
            @Result(property = "age", column = "user_age"),
            @Result(property = "birthday", column = "user_birthday"),
            @Result(property = "registerTime", column = "regist_time"),
            @Result(property = "sign", column = "user_sign")
    })
    User findByName(@Param(value = "name") String name);

    @Insert("INSERT INTO user(id,user_name,user_password) VALUES(#{userId},#{userName},#{password})")
    @Results({
            @Result(property = "userId", column = "id"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "password", column = "user_password")
    })
    void addUser(User user);
}
