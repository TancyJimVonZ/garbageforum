package com.tancyj.forum.dao;

import com.tancyj.forum.domain.Role;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface IRoleDao {
    @Select("select * from role")
    @Results(id = "roleMap",
            value = {
                    @Result(id = true,column = "roleid",property = "roleid"),
                    @Result(column = "role",property = "role"),
                    @Result(column = "roleid",property = "users",
                            many = @Many(
                                    select="com.tancyj.forum.dao.IUserDao.findById",
                                    fetchType= FetchType.LAZY
                            )
                    ),
            }
    )
    public List<Role> findAll() throws Exception;
    @Insert("insert into role(role) VALUES(#{role})")
    public void addrole(Role role) throws Exception;

    @Insert("UPDATE role set role = #{role} WHERE roleid = #{roleid};")
    public void updaterole(Role role) throws Exception;

    @Delete("delete from role where roleid = #{roleid}")
    public void delrole(Integer roleid) throws Exception;

    @ResultMap("roleMap")
    @Select("select * from role where roleid = #{roleid}")
    public Role findById(Integer roleid) throws Exception;

//    @Select("select * from role where role_id = #{role_id}")
//    public Role findByRoleid(Integer role_id) throws Exception;


}
