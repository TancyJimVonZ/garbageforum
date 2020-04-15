package com.tancyj.forum.service.impl;

import com.tancyj.forum.dao.IRoleDao;
import com.tancyj.forum.domain.Role;
import com.tancyj.forum.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleDao roleDao;

    @Override
    public List<Role> findAll() throws Exception {
        List<Role> roles = roleDao.findAll();
        return roles;
    }

    @Override
    public void addrole(Role role) throws Exception {
        roleDao.addrole(role);
    }

    @Override
    public void updaterole(Role role) throws Exception {
        roleDao.updaterole(role);
    }

    @Override
    public void delrole(Integer role_id) throws Exception {
        roleDao.delrole(role_id);
    }

    @Override
    public Role findById(Integer role_id) throws Exception {
        Role role = roleDao.findById(role_id);
        return role;
    }
}
