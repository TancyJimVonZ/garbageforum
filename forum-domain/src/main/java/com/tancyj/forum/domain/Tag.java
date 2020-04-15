package com.tancyj.forum.domain;

import java.io.Serializable;
import java.util.List;

public class Tag implements Serializable {
    private Integer tag_id;
    private String tag;
    private List<Post> posts;

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public Integer getTag_id() {
        return tag_id;
    }

    public void setTag_id(Integer tag_id) {
        this.tag_id = tag_id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }


    @Override
    public String toString() {
        return "Tag{" +
                "tag_id=" + tag_id +
                ", tag='" + tag + '\'' +
                ", posts=" + posts +
                '}';
    }
}
