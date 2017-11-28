package com.learning.domain.user;

/**
 * Created by shenjixiaodao on 2017/11/24.
 */
public class Comment {
    private Long userId;
    private String unickname;
    private Long teacherId;
    private String tnickname;
    private Integer star;
    private String comment;
    private String keyword;

    public Comment(Long userId, Long teacherId, Integer star) {
        this.userId = userId;
        this.teacherId = teacherId;
        this.star = star;
    }

    public void comment(String comment) {
        this.comment = comment;
    }

    public void keyword(String keyword) {
        this.keyword = keyword;
    }

    Comment() {
    }
}
