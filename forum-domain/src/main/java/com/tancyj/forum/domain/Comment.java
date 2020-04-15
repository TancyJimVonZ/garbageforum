package com.tancyj.forum.domain;

import com.tancyj.forum.utils.DateUtils;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;

public class Comment implements Serializable {
    private Integer cid;
    private Date time;
    private String timeStr;
    private String content;
    private Integer likes;
    private Integer dislike;
    private Integer pid;
    private Integer uid;
    private Integer ccid;
    private String content_image;
    private String isdelete;
    private String isdeleteStr;
    private User user;
    private Post post;

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(String time) throws ParseException {
        this.time = DateUtils.stringtoDate(time,"yyyy-MM-dd");

    }

    public String getTimeStr() {
        if(time != null){
            timeStr = DateUtils.datetoString(time, "yyyy-MM-dd");
        }
        return timeStr;
    }

    public void setTimeStr(String timeStr) {
        this.timeStr = timeStr;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getDislike() {
        return dislike;
    }

    public void setDislike(Integer dislike) {
        this.dislike = dislike;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getCcid() {
        return ccid;
    }

    public void setCcid(Integer ccid) {
        this.ccid = ccid;
    }

    public String getContent_image() {
        return content_image;
    }

    public void setContent_image(String content_image) {
        this.content_image = content_image;
    }

    public String getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(String isdelete) {
        this.isdelete = isdelete;
    }

    public String getIsdeleteStr() {
        if(isdelete == "1"){
            isdeleteStr = "审核中";
        }else if(isdelete == "2"){
            isdeleteStr = "正常";
        }else if(isdelete == "3"){
            isdeleteStr = "删除";
        }
        return isdeleteStr;
    }

    public void setIsdeleteStr(String isdeleteStr) {
        this.isdeleteStr = isdeleteStr;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "cid=" + cid +
                ", time=" + time +
                ", timeStr='" + timeStr + '\'' +
                ", content='" + content + '\'' +
                ", likes=" + likes +
                ", dislike=" + dislike +
                ", pid=" + pid +
                ", uid=" + uid +
                ", ccid=" + ccid +
                ", content_image='" + content_image + '\'' +
                ", isdelete='" + isdelete + '\'' +
                ", isdeleteStr='" + isdeleteStr + '\'' +
                ", user=" + user +
                ", post=" + post +
                '}';
    }
}
