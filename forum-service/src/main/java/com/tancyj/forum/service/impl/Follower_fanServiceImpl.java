package com.tancyj.forum.service.impl;

import com.tancyj.forum.dao.IFollower_fanDao;
import com.tancyj.forum.domain.Follower_fan;
import com.tancyj.forum.service.IFollower_fanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class Follower_fanServiceImpl implements IFollower_fanService {
    @Autowired
    private IFollower_fanDao follower_fanDao;

    @Override
    public List<Follower_fan> findAll() throws Exception {
        List<Follower_fan> follower_fans = follower_fanDao.findAll();
        return follower_fans;
    }

    @Override
    public void addfollower_fan(Follower_fan follower_fan) throws Exception {
        follower_fanDao.addfollower_fan(follower_fan);
    }

    @Override
    public void updatefollower_fan(Follower_fan followers_fan) throws Exception {
        follower_fanDao.updatefollower_fan(followers_fan);
    }

    @Override
    public void delfollower_fan(Integer id) throws Exception {
        follower_fanDao.delfollower_fan(id);
    }

    @Override
    public Follower_fan findById(Integer id) throws Exception {
        Follower_fan follower_fan = follower_fanDao.findById(id);
        return follower_fan;
    }
}
