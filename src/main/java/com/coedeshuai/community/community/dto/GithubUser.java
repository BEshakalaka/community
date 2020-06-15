package com.coedeshuai.community.community.dto;

/**
 * @author ：codeshuai
 * @date ：Created in 2020/6/14 11:20
 */
public class GithubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatar_url;

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
