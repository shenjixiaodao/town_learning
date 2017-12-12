package com.learning.webapi.vo;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by shenjixiaodao on 2017/12/12.
 */
public class TutorshipCommentVo {

    @ApiModelProperty(value="评论用户ID", required = true)
    private Long studentId;
    @ApiModelProperty(value="被评论用户ID", required = true)
    private Long teacherId;
    @ApiModelProperty(value="评分", required = true)
    private Integer star;
    @ApiModelProperty(value="标签")
    private String keyword;
    @ApiModelProperty(value="评论内容")
    private String comment;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "TutorshipCommentVo{" +
                "studentId=" + studentId +
                ", teacherId=" + teacherId +
                ", star=" + star +
                ", keyword='" + keyword + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
