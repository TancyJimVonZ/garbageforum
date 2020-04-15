package com.tancyj.forum.service.impl;

import com.tancyj.forum.dao.IPostDao;
import com.tancyj.forum.dao.IProclamationDao;
import com.tancyj.forum.domain.Post;
import com.tancyj.forum.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class PostServiceImpl implements IPostService {
    @Autowired
    private IPostDao postDao;


    @Override
    public List<Post> findAll() throws Exception {
        List<Post> posts = postDao.findAll();
        return posts;
    }

    @Override
    public void addpost(Post post) throws Exception {
        postDao.addpost(post);
    }

    @Override
    public void updatepost(Post post) throws Exception {
        postDao.updatepost(post);
    }

    @Override
    public void delpost(Integer pid) throws Exception {
        postDao.delpost(pid);
    }

    @Override
    public Post findById(Integer pid) throws Exception {
        Post post = postDao.findById(pid);
        return post;
    }
}
