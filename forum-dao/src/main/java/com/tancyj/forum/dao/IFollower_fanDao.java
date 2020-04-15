package com.tancyj.forum.dao;

import com.tancyj.forum.domain.Follower_fan;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IFollower_fanDao {
    @Select("select * from follower_fan")
    public List<Follower_fan> findAll() throws Exception;
    @Insert("insert into follower_fan(followers_id,fans_id) VALUES(#{followers_id},#{fans_id})")
    public void addfollower_fan(Follower_fan follower_fan) throws Exception;

    @Insert("UPDATE follower_fan set followers_id = #{followers_id},fans_id = #{fans_id} WHERE id = #{id};")
    public void updatefollower_fan(Follower_fan followers_fan) throws Exception;

    @Delete("delete from follower_fan where id = #{id}")
    public void delfollower_fan(Integer id) throws Exception;

    @Select("select * from follower_fan where id = #{id}")
    public Follower_fan findById(Integer id) throws Exception;


}
