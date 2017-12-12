package com.learning.webapi.vo;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by shenjixiaodao on 2017/12/12.
 */
public class SkilledVo {
    @ApiModelProperty(value="用户ID", required = true)
    private Long uid;
    @ApiModelProperty(value="科目ids", dataType = "Integer", required = true)
    private List<Integer> subjectIds;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public List<Integer> getSubjectIds() {
        return subjectIds;
    }

    public void setSubjectIds(List<Integer> subjectIds) {
        this.subjectIds = subjectIds;
    }

    @Override
    public String toString() {
        return "SkilledVo{" +
                "uid=" + uid +
                ", subjectIds=" + subjectIds +
                '}';
    }
}
