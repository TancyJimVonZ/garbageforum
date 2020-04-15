package com.tancyj.forum.dao;

import com.tancyj.forum.domain.Comment;
import com.tancyj.forum.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ICommentDao {
    @Select("select * from comment")
    @Results(id = "commentMap",
            value = {
                    @Result(id = true,column = "cid",property = "cid"),
                    @Result(column = "content",property = "content"),
                    @Result(column = "time",property = "time"),
                    @Result(column = "likes",property = "likes"),
                    @Result(column = "dislike",property = "dislike"),
                    @Result(column = "content_image",property = "content_image"),
                    @Result(column = "isdelete",property = "isdelete"),
                    @Result(column = "pid",property = "post",
                            one = @One(
                                    select="com.tancyj.forum.dao.IPostDao.findById",
                                    fetchType= FetchType.LAZY
                            )
                    ),
                    @Result(column = "uid",property = "user",
                            one = @One(
                                    select="com.tancyj.forum.dao.IUserDao.findById",
                                    fetchType= FetchType.LAZY
                            )
                    ),
            }
    )
    public List<Comment> findAll() throws Exception;
    @Insert("insert into comment(content,likes,dislike,time,pid,uid,ccid,content_image,isdelete) VALUES(#{content},#{likes},#{dislike},#{time},#{pid},#{uid},#{ccid},#{content_image},#{isdelete})")
    public void addcomment(Comment comment) throws Exception;

    @Update("update comment set content = #{content},likes = #{likes},dislike = #{dislike},time = #{time},pid = #{pid},\n" +
            "uid = #{uid},ccid = #{ccid},content_image = #{content_image},isdelete = #{isdelete} WHERE cid = #{cid}")
    public void updatecomment(Comment comment) throws Exception;

    @Delete("delete from comment where cid = #{cid}")
    public void delcomment(Integer cid) throws Exception;

    @ResultMap("commentMap")
    @Select("select * from comment where cid = #{cid}")
    public Comment findById(Integer cid) throws Exception;


    @Select("select * from comment where uid = #{uid}")
    public Comment findByUid(Integer uid) throws Exception;

}
