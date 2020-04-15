package com.tancyj.forum.service;

import com.tancyj.forum.domain.Comment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ICommentService {
    public List<Comment> findAll() throws Exception;
    public void addcomment(Comment comment) throws Exception;

    public void updatecomment(Comment comment) throws Exception;

    public void delcomment(Integer uid) throws Exception;

    public Comment findById(Integer uid) throws Exception;

}
