package cn.edu.nju.tourist.bean;

import java.util.Date;

/**
 * 文章列
 *
 * @author fanleehao on 2019/1/15
 * DROP TABLE IF EXISTS `post`;
 * CREATE TABLE `post`  (
 *   `id` bigint(20) NOT NULL COMMENT 'id',
 *   `post_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
 *   `post_context` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '内容',
 *   `post_time` date NULL DEFAULT NULL COMMENT '时间',
 *   `post_last_edit` date NULL DEFAULT NULL COMMENT '最近一次修改',
 *   `post_images` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '插图地址',
 *   `post_location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '相关地区',
 *   `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
 *   PRIMARY KEY (`id`) USING BTREE,
 *   INDEX `user_name`(`user_name`) USING BTREE,
 *   CONSTRAINT `user_name` FOREIGN KEY (`user_name`) REFERENCES `user` (`user_name`) ON DELETE RESTRICT ON UPDATE RESTRICT
 * ) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
 */
public class Post {
    private int id;
    private String post_title;
    private String post_context;
    private Date post_time;
    private Date post_last_edit;
    private String post_images;
    private String post_location;
    private String user_name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPost_title() {
        return post_title;
    }

    public void setPost_title(String post_title) {
        this.post_title = post_title;
    }

    public String getPost_context() {
        return post_context;
    }

    public void setPost_context(String post_context) {
        this.post_context = post_context;
    }

    public Date getPost_time() {
        return post_time;
    }

    public void setPost_time(Date post_time) {
        this.post_time = post_time;
    }

    public Date getPost_last_edit() {
        return post_last_edit;
    }

    public void setPost_last_edit(Date post_last_edit) {
        this.post_last_edit = post_last_edit;
    }

    public String getPost_images() {
        return post_images;
    }

    public void setPost_images(String post_images) {
        this.post_images = post_images;
    }

    public String getPost_location() {
        return post_location;
    }

    public void setPost_location(String post_location) {
        this.post_location = post_location;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", post_title='" + post_title + '\'' +
                ", post_context='" + post_context + '\'' +
                ", post_time=" + post_time +
                ", post_last_edit=" + post_last_edit +
                ", post_images='" + post_images + '\'' +
                ", post_location='" + post_location + '\'' +
                ", user_name='" + user_name + '\'' +
                '}';
    }
}
