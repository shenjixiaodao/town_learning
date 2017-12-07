package com.learning.webapi.vo;


import io.swagger.annotations.ApiModelProperty;

/**
 * Created by shenjixiaodao on 2017/11/24.
 */
public class UserVo {
    private Long id;
    @ApiModelProperty(value="昵称", required = true)
    private String nickname;
    @ApiModelProperty(value="微信ID", required = true)
    private String wechatId;
    private String role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getWechatId() {
        return wechatId;
    }

    public void setWechatId(String wechatId) {
        this.wechatId = wechatId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", wechatId='" + wechatId + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
