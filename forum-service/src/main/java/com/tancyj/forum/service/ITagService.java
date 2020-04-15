package com.tancyj.forum.service;

import com.tancyj.forum.domain.Tag;


import java.util.List;

public interface ITagService {
    public List<Tag> findAll() throws Exception;
    public void addtag(Tag tag) throws Exception;
    public void updatetag(Tag tag) throws Exception;
    public void deltag(Integer tag_id) throws Exception;
    public Tag findById(Integer tag_id) throws Exception;

}
