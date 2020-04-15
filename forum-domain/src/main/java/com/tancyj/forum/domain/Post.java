package com.tancyj.forum.domain;

import com.tancyj.forum.utils.DateUtils;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

public class Post implements Serializable {
    private Integer pid;
    private String pcontent;
    private String title;
    private Date ptime;
    private String ptimeStr;
    private String image;
    private Integer top;
    private Integer hot;
    private Integer type_id;
    private Integer uid;
    private String isdelete;
    private String isdeleteStr;
    private User user;
    private Type type;
    private List<Tag> tags;
    private List<Comment> comments;

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPcontent() {
        return pcontent;
    }

    public void setPcontent(String pcontent) {
        this.pcontent = pcontent;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPtime() {
        return ptime;
    }

    public void setPtime(String ptime) throws ParseException {
        this.ptime = DateUtils.stringtoDate(ptime,"yyyy-MM-dd");
    }

    public String getPtimeStr() {
        if(ptime != null){
            ptimeStr = DateUtils.datetoString(ptime, "yyyy-MM-dd");
        }
        return ptimeStr;
    }

    public void setPtimeStr(String ptimeStr) {
        this.ptimeStr = ptimeStr;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
    }

    public Integer getHot() {
        return hot;
    }

    public void setHot(Integer hot) {
        this.hot = hot;
    }

    public Integer getType_id() {
        return type_id;
    }

    public void setType_id(Integer type_id) {
        this.type_id = type_id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
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

    @Override
    public String toString() {
        return "Post{" +
                "pid=" + pid +
                ", pcontent='" + pcontent + '\'' +
                ", title='" + title + '\'' +
                ", ptime=" + ptime +
                ", ptimeStr='" + ptimeStr + '\'' +
                ", image='" + image + '\'' +
                ", top=" + top +
                ", hot=" + hot +
                ", type_id=" + type_id +
                ", uid=" + uid +
                ", isdelete='" + isdelete + '\'' +
                ", isdeleteStr='" + isdeleteStr + '\'' +
                ", user=" + user +
                ", type=" + type +
                ", tags=" + tags +
                ", comments=" + comments +
                '}';
    }
}