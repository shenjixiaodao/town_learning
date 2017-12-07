package com.learning.domain.user;

import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        public static Type typeOf(String type) {
            if(StringUtils.isEmpty(type)) {
                throw new IllegalArgumentException("type不能为空");
            }
            for(Type t:Type.values()) {
                if(t.lowcaseName().equals(type.toLowerCase()))
                    return t;
            }
            throw new IllegalArgumentException("位置附件类型");
        }
    }

    public String fileLocation(String parentDir) {
        File dir = new File(parentDir + File.separator + this.type.lowcaseName());
        if(!dir.exists()) {
            dir.mkdir();
        }
        return dir.getAbsolutePath() + File.separator + this.name;
    }

    public static String toStoreFilename(String srcFilename) {
        String fileType = srcFilename.substring(srcFilename.lastIndexOf("."));
        return new SimpleDateFormat("yyyyMMddHHmmssSSSS").format(new Date()) + fileType;
    }

    Attachment() {
    }
}
