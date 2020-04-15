package com.tancyj.forum.service;

import com.tancyj.forum.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {
    public List<User> findAll(int page,int size) throws Exception;
    public void adduser(User user) throws Exception;
    public void updateuser(User user) throws Exception;
    public void deluser(Integer uid) throws Exception;

    public User findById(Integer uid) throws Exception;
}
