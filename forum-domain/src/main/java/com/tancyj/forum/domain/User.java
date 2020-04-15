package com.tancyj.forum.domain;

import com.tancyj.forum.utils.DateUtils;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

public class User implements Serializable {
    private Integer uid;
    private String name;
    private String username;
    private String  password;
    private String sex;
    private String email;
    private String phone;
    private Date birthday;
    private String birthdayStr;
    private String image_head;
    private String image_back;
    private Integer heavy;
    private String idcard_num;
    private Integer status_id;
    private String  statusStr;
    private String page;
    private String roleStr;
    private String wechat;
    private Integer role_id;
    private Role role;
    private List<Post> posts;
    private List<Comment> comments;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) throws ParseException {
        this.birthday = DateUtils.stringtoDate(birthday,"yyyy-MM-dd");
    }

    public String getBirthdayStr() {
        if(birthday != null){
//            birthdayStr = DateUtils.datetoString(birthday,"yyyy-MM-dd HH:mm:ss");
            birthdayStr = DateUtils.datetoString(birthday,"yyyy-MM-dd ");
        }
        return birthdayStr;
    }

    public void setBirthdayStr(String birthdayStr) {
        this.birthdayStr = birthdayStr;
    }

    public String getImage_head() {
        return image_head;
    }

    public void setImage_head(String image_head) {
        this.image_head = image_head;
    }

    public String getImage_back() {
        return image_back;
    }

    public void setImage_back(String image_back) {
        this.image_back = image_back;
    }

    public Integer getHeavy() {
        return heavy;
    }

    public void setHeavy(Integer heavy) {
        this.heavy = heavy;
    }

    public String getIdcard_num() {
        return idcard_num;
    }

    public void setIdcard_num(String idcard_num) {
        this.idcard_num = idcard_num;
    }

    public Integer getStatus_id() {
        return status_id;
    }

    public void setStatus_id(Integer status_id) {
        this.status_id = status_id;
    }

    public String getStatusStr() {
        if(status_id != null){
            if(status_id == 0){
                statusStr = "未激活";
            }else if(status_id == 1){
                statusStr = "正常";
            }else if(status_id == 2){
                statusStr = "被封禁";
            }
        }
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getRoleStr() {
        return roleStr;
    }

    public void setRoleStr(String roleStr) {
        this.roleStr = roleStr;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }


    public Role getRole() {
        return role;
    }


    public void setRole(Role role) {
        this.role = role;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", birthday=" + birthday +
                ", birthdayStr='" + birthdayStr + '\'' +
                ", image_head='" + image_head + '\'' +
                ", image_back='" + image_back + '\'' +
                ", heavy=" + heavy +
                ", idcard_num='" + idcard_num + '\'' +
                ", status_id=" + status_id +
                ", statusStr='" + statusStr + '\'' +
                ", page='" + page + '\'' +
                ", roleStr='" + roleStr + '\'' +
                ", wechat='" + wechat + '\'' +
                ", role_id=" + role_id +
                ", role=" + role +
                ", posts=" + posts +
                ", comments=" + comments +
                '}';
    }
}
