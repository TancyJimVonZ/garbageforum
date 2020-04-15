package com.tancyj.forum.service.impl;


import com.github.pagehelper.PageHelper;
import com.tancyj.forum.dao.IUserDao;
import com.tancyj.forum.domain.Role;
import com.tancyj.forum.domain.User;
import com.tancyj.forum.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<User> findAll(int page,int size) throws Exception {
        PageHelper.startPage(page,size);
        List<User> users = userDao.findAll();
        return users;
    }

    @Override
    public void adduser(User user) throws Exception {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userDao.adduser(user);
        return;
    }

    @Override
    public void updateuser(User user) throws Exception {
        userDao.updateuser(user);
    }


    @Override
    public void deluser(Integer uid) throws Exception {
        userDao.deluser(uid);
    }

    @Override
    public User findById(Integer uid) throws Exception {
        User user = userDao.findById(uid);
        return user;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = null;
        try {
            user = userDao.findByUsername(username);
//            System.out.println(username);
//            System.out.println(user);
            System.out.println(user.getRole().getRole());

        } catch (Exception e) {
            e.printStackTrace();
        }
        org.springframework.security.core.userdetails.User user_sec = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),user.getStatus_id() == 0 ? false : true, true, true, true,getAuthority(user.getRole()));
//        org.springframework.security.core.userdetails.User user_sec = new org.springframework.security.core.userdetails.User(user.getUsername(),"{noop}"+ user.getPassword(),user.getStatus_id() == 0 ? false : true, true, true, true,getAuthority(user.getRole()));
        return user_sec;
    }

    //作用就是返回一个List集合，集合中装入的是角色描述
    public List<SimpleGrantedAuthority> getAuthority(Role role) {

        List<SimpleGrantedAuthority> list = new ArrayList<>();
//
//        list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
//
        list.add(new SimpleGrantedAuthority("ROLE_"+role.getRole()));
        return list;
    }
}
