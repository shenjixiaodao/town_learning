package com.learning.domain.room;

/**
 * Created by shenjixiaodao on 2017/11/24.
 */
public class Subject {

    private Integer id;
    private String name;
    private String grade;
    //科目最高允许人数
    private Integer limitCount;

    public Integer id() {
        return id;
    }

    public String name() {
        return name;
    }

    public String grade() {
        return grade;
    }

    public Integer limitCount() {
        return limitCount;
    }
}
