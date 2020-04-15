package com.tancyj.forum.domain;

import java.io.Serializable;
import java.util.List;

public class Role implements Serializable {
    private Integer roleid;
    private String role;
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    @Override
    public String toString() {
//        return "Role{" +
//                "roleid=" + roleid +
//                ", role='" + role + '\'' +
//                ", users=" + users +
//                '}';
        return "Role{" +
                "roleid=" + roleid +
                ", role='" + role + '\'' +
                '}';
    }
}
