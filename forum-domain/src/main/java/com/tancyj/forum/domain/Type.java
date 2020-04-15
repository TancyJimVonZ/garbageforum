package com.tancyj.forum.domain;

import javafx.geometry.Pos;

import java.io.Serializable;
import java.util.List;

public class Type implements Serializable {
    private Integer type_id;
    private String type;
    private List<Post> posts;

    public Integer getType_id() {
        return type_id;
    }

    public void setType_id(Integer type_id) {
        this.type_id = type_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "Type{" +
                "type_id=" + type_id +
                ", type='" + type + '\'' +
                ", posts=" + posts +
                '}';
    }
}
