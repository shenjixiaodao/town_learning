package com.learning.domain.subject;

/**
 * Created by shenjixiaodao on 2017/11/24.
 */
public class Subject {

    private Integer id;
    private String name;
    private String grade;
    //科目最高允许人数
    private Integer limitCount;

    public Subject(Integer id) {
        this.id = id;
    }

    Subject() {
    }

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

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade='" + grade + '\'' +
                ", limitCount=" + limitCount +
                '}';
    }
}
