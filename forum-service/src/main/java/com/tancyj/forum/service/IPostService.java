package com.tancyj.forum.service;

import com.tancyj.forum.domain.Post;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface IPostService {
    public List<Post> findAll() throws Exception;
    public void addpost(Post post) throws Exception;
    public void updatepost(Post post) throws Exception;
    public void delpost(Integer pid) throws Exception;
    public Post findById(Integer pid) throws Exception;

}
