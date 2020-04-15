package com.tancyj.forum.dao;

import com.tancyj.forum.domain.Post;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface IPostDao {
    @Select("select * from post")
    @Results(id = "postMap",
            value = {
                    @Result(id = true,column = "pid",property = "pid"),
                    @Result(column = "pcontent",property = "pcontent"),
                    @Result(column = "title",property = "title"),
                    @Result(column = "ptime",property = "ptime"),
                    @Result(column = "image",property = "image"),
                    @Result(column = "top",property = "top"),
                    @Result(column = "hot",property = "hot"),
                    @Result(column = "isdelete",property = "isdelete"),
                    @Result(column = "type_id",property = "type",
                            one = @One(
                                    select="com.tancyj.forum.dao.ITypeDao.findById",
                                    fetchType= FetchType.LAZY
                            )

                    ),
                    @Result(column = "pid",property = "tags",
                            many = @Many(
                                    select="com.tancyj.forum.dao.ITagDao.findByPostId",
                                    fetchType= FetchType.LAZY
                            )

                    ),
                    @Result(column = "cid",property = "comments",
                            one = @One(
                                    select="com.tancyj.forum.dao.ICommentDao.findById",
                                    fetchType= FetchType.LAZY
                            )
                    ),
                    @Result(column = "uid",property = "user",
                            one = @One(
                                    select="com.tancyj.forum.dao.IUserDao.findByUid",
                                    fetchType= FetchType.LAZY
                            )
                    ),
            }
    )
    public List<Post> findAll() throws Exception;
    @Insert("insert into post(pcontent,title,ptime,image,top,hot,type_id,uid,isdelete) " +
            "VALUES(#{pcontent},#{title},#{ptime},#{image},#{top},#{hot},#{type_id},#{uid},#{isdelete})")
    public void addpost(Post post) throws Exception;

    @Update("UPDATE post set pcontent = #{pcontent},title = #{title},ptime = #{ptime},image = #{image},top = #{top},\n" +
            "hot = #{hot},type_id = #{type_id},uid = #{uid},isdelete = #{isdelete} WHERE pid = #{pid}")
    public void updatepost(Post post) throws Exception;

    @Delete("delete from post where pid = #{pid}")
    public void delpost(Integer pid) throws Exception;

    @ResultMap("postMap")
    @Select("select * from post where pid = #{pid}")
    public Post findById(Integer pid) throws Exception;


    @Select("select * from post where uid = #{uid}")
    public Post findByUid(Integer uid) throws Exception;

    @Select("select * from post where type_id = #{type_id}")
    public Post findByTid(Integer type_id) throws Exception;

    @Select("select * from post where pid in (select post_id from map_tag_po where tag_id = #{tag_id}) ")
    public List<Post> findByTagid(Integer tag_id) throws Exception;


}
