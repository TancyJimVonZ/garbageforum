package com.tancyj.forum.dao;

import com.tancyj.forum.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;


public interface IUserDao {
//    @Select("select * from user")
//    public List<User> findAll() throws Exception;
    @Select("select * from user")
    @Results(id = "userMap",
        value = {
            @Result(id = true,column = "uid",property = "uid"),
            @Result(column = "name",property = "name"),
            @Result(column = "username",property = "username"),
            @Result(column = "password",property = "password"),
            @Result(column = "sex",property = "sex"),
            @Result(column = "email",property = "email"),
            @Result(column = "birthday",property = "birthday"),
            @Result(column = "image_head",property = "image_head"),
            @Result(column = "image_back",property = "image_back"),
            @Result(column = "heavy",property = "heavy"),
            @Result(column = "idcard_num",property = "idcard_num"),
            @Result(column = "status_id",property = "status_id"),
            @Result(column = "page",property = "page"),
            @Result(column = "role_id",property = "role",
                    one = @One(
                            select="com.tancyj.forum.dao.IRoleDao.findById",
                            fetchType= FetchType.LAZY
                    )
            ),
            @Result(column = "uid",property = "comments",
                        many = @Many(
                                select="com.tancyj.forum.dao.ICommentDao.findByUid",
                                fetchType= FetchType.LAZY
                        )
            ),
            @Result(column = "uid",property = "posts",
                    many = @Many(
                            select="com.tancyj.forum.dao.IPostDao.findByUid",
                            fetchType= FetchType.LAZY
                    )
            ),
        }
    )
    public List<User> findAll() throws Exception;



    @Insert("insert into user(name,username,`password`,email,birthday,sex,phone,image_head,image_back,heavy,idcard_num,status_id,page,role_id,wechat) " +
            "VALUES(#{name},#{username},#{password},#{email},#{birthday},#{sex},#{phone},#{image_head},#{image_back},#{heavy},#{idcard_num},#{status_id},#{page},#{role_id},#{wechat})")
    public void adduser(User user) throws Exception;

    @Update("UPDATE user set name = #{name},username = #{username},password = #{password},sex = #{sex},email = #{email},\n" +
            "birthday = #{birthday},phone = #{phone},status_id = #{status_id},image_head = #{image_head},image_back=#{image_back},\n" +
            "role_id = #{role_id},heavy = #{heavy},page = #{page},idcard_num = #{idcard_num},wechat = #{wechat} WHERE uid = #{uid}")
    public void updateuser(User user) throws Exception;

    @Delete("delete from user where uid = #{uid}")
    public void deluser(Integer uid) throws Exception;

    @ResultMap("userMap")
    @Select("select * from user where uid = #{uid}")
    public User findById(Integer uid) throws Exception;


    @Select("select * from user where uid = #{uid}")
    public User findByUid(Integer uid) throws Exception;

    @ResultMap("userMap")
    @Select("select * from user where username = #{username}")
    public User findByUsername(String username) throws Exception;

}
