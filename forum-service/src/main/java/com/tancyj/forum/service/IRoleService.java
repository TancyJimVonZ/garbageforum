package com.tancyj.forum.service;

import com.tancyj.forum.domain.Role;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IRoleService {
    public List<Role> findAll() throws Exception;
    public void addrole(Role role) throws Exception;
    public void updaterole(Role role) throws Exception;
    public void delrole(Integer role_id) throws Exception;
    public Role findById(Integer role_id) throws Exception;

}
