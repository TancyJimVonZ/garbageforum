package com.tancyj.forum.domain;

import java.io.Serializable;

public class Follower_fan implements Serializable {
    private Integer id;
    private Integer followers_id;
    private Integer fans_id;

    @Override
    public String toString() {
        return "Follower_fan{" +
                "id=" + id +
                ", followers_id=" + followers_id +
                ", fans_id=" + fans_id +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFollowers_id() {
        return followers_id;
    }

    public void setFollowers_id(Integer followers_id) {
        this.followers_id = followers_id;
    }

    public Integer getFans_id() {
        return fans_id;
    }

    public void setFans_id(Integer fans_id) {
        this.fans_id = fans_id;
    }
}
