package com.tancyj.forum.service.impl;

import com.tancyj.forum.dao.ICommentDao;
import com.tancyj.forum.domain.Comment;
import com.tancyj.forum.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class CommentServiceImpl  implements ICommentService {
    @Autowired
    private ICommentDao commentDao;

    @Override
    public List<Comment> findAll() throws Exception {
        List<Comment> comments = commentDao.findAll();
        return comments;
    }

    @Override
    public void addcomment(Comment comment) throws Exception {
        commentDao.addcomment(comment);
    }

    @Override
    public void updatecomment(Comment comment) throws Exception {
        commentDao.updatecomment(comment);
    }

    @Override
    public void delcomment(Integer uid) throws Exception {
        commentDao.delcomment(uid);
    }

    @Override
    public Comment findById(Integer uid) throws Exception {
        Comment comment = commentDao.findById(uid);
        return comment;
    }
}
