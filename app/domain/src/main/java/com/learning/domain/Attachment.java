package com.learning.domain;

/**
 * Created by shenjixiaodao on 2017/11/24.
 */
public class Attachment {

    private Long userId;
    private Long id;
    private String name;
    private String location;
    private Type type;

    public Attachment(Long userId, String name, String location, Type type) {
        this.userId = userId;
        this.name = name;
        this.location = location;
        this.type = type;
    }

    public String name() {
        return name;
    }

    public String location() {
        return location;
    }

    public Type type() {
        return type;
    }

    public enum Type {
        Identity("身份证"), College("学生证"), Diploma("文凭"), Certificate("执照");
        private String text;
        Type(String text) {
            this.text = text;
        }
        public String text() {
            return text;
        }
        public boolean isIdentity() {
            return this == Identity;
        }
    }

    Attachment() {
    }
}
