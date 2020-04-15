package com.tancyj.forum.dao;

import com.tancyj.forum.domain.Tag;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface ITagDao {
//    @Select("select * from tag")
//    public List<Tag> findAll() throws Exception;

//    @Select("select * from tag")
//    @ResultMap("tagMap")
//    @Select("SELECT tag.*,post.* FROM post LEFT JOIN map_tag_po on #{post.pid} = #{map_tag_po.post_id} LEFT JOIN tag on #{map_tag_po.tag_id} = #{tag.tag_id};")
    @Select("select * from tag")
    @Results(id = "tagMap",
            value = {
                    @Result(id = true,column = "tag_id",property = "tag_id"),
                    @Result(column = "tag",property = "tag"),
                    @Result(column = "tag_id",property = "posts",
                            many = @Many(
                                    select="com.tancyj.forum.dao.IPostDao.findByTagid",
                                    fetchType= FetchType.LAZY
                            )
                    ),
            }
    )
    public List<Tag> findAll() throws Exception;


    @Insert("insert into tag(tag) VALUES(#{tag})")
    public void addtag(Tag tag) throws Exception;

    @Update("UPDATE tag set tag = #{tag} WHERE tag_id = #{tag_id};")
    public void updatetag(Tag tag) throws Exception;

    @Delete("delete from tag where tag_id = #{tag_id}")
    public void deltag(Integer tag_id) throws Exception;

    @ResultMap("tagMap")
    @Select("select * from tag where tag_id = #{tag_id}")
    public Tag findById(Integer tag_id) throws Exception;



    @Select("select * from tag where tag_id in (select tag_id from map_tag_po where post_id = #{post_id})")
    public List<Tag> findByPostId(Integer post_id) throws Exception;


    //public Tag findByallpost() throws Exception;


}
