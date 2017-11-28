package com.learning.domain.user;

import java.io.File;

/**
 * Created by shenjixiaodao on 2017/11/24.
 */
public class Attachment {

    private Long userId;
    private Long id;
    //uuid
    private String name;
    private String location;
    private Type type;
    //上传附件是否被使用: 0:未被关联, 1:是被关联
    private Integer isAssociated;
    private final static int Associated = 1, Unassociated = 0;

    public Attachment(Long id, Type type) {
        this.id = id;
        this.type = type;
        this.isAssociated = Unassociated;
    }

    public Attachment(Long userId, String name, Type type) {
        this.userId = userId;
        this.name = name;
        this.type = type;
        this.isAssociated = Unassociated;
    }

    /**
     * 关联附件
     */
    public void associated() {
        this.isAssociated = Associated;
    }

    public String name() {
        return name;
    }

    public String location() {
        return location;
    }

    public void location(String location) {
        this.location = location;
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
        public String lowcaseName() {
            return this.toString().toLowerCase();
        }
    }

    public String fileLocation(String parentDir) {
        File dir = new File(parentDir + File.separator + this.type.lowcaseName());
        if(!dir.exists()) {
            dir.mkdir();
        }
        return dir.getAbsolutePath() + File.separator + this.name;
    }

    Attachment() {
    }
}
