package com.tancyj.forum.service;

import com.tancyj.forum.domain.Follower_fan;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IFollower_fanService {
    public List<Follower_fan> findAll() throws Exception;
    public void addfollower_fan(Follower_fan follower_fan) throws Exception;
    public void updatefollower_fan(Follower_fan followers_fan) throws Exception;
    public void delfollower_fan(Integer id) throws Exception;
    public Follower_fan findById(Integer id) throws Exception;

}
