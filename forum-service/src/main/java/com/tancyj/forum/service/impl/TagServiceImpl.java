package com.tancyj.forum.service.impl;

import com.tancyj.forum.dao.ITagDao;
import com.tancyj.forum.dao.ITypeDao;
import com.tancyj.forum.domain.Tag;
import com.tancyj.forum.service.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class TagServiceImpl implements ITagService {
    @Autowired
    private ITagDao tagDao;

    @Override
    public List<Tag> findAll() throws Exception {
        List<Tag> tags = tagDao.findAll();
        return tags;
    }

    @Override
    public void addtag(Tag tag) throws Exception {
        tagDao.addtag(tag);
    }

    @Override
    public void updatetag(Tag tag) throws Exception {
        tagDao.updatetag(tag);
    }

    @Override
    public void deltag(Integer tag_id) throws Exception {
        tagDao.deltag(tag_id);
    }

    @Override
    public Tag findById(Integer tag_id) throws Exception {
        Tag tag = tagDao.findById(tag_id);
        return tag;
    }
}
