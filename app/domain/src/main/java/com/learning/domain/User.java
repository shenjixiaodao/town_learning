package com.learning.domain;

import org.springframework.util.Assert;

import java.util.List;

/**
 * Created by shenjixiaodao on 2017/11/24.
 */
public class User {
    private Long id;
    private String wechatId;
    private Role role;
    private List<Subject> beSkilledIn;
    private List<Attachment> attachments;
    private List<Comment> comments;

    /**
     * 申请成为老师必须上传身份证照片 和 至少一项资历证明
     * @param attachments
     */
    public void applyForTeacher(List<Attachment> attachments) {
        Assert.notNull(attachments, "附件为空");
        Assert.isTrue(attachments.size() > 1, "需要包括身份证明和至少一份资历证明");
        Assert.isTrue(hasIdentity(attachments), "缺少身份证明");
        this.attachments = attachments;
    }
    private static boolean hasIdentity(List<Attachment> attachments){
        for (Attachment attachment : attachments){
            if(attachment.type().isIdentity())
                return true;
        }
        return false;
    }

    public enum  Role {
        Student("学生") , Teacher("老师");
        private String text;
        Role(String text) {
            this.text = text;
        }
        public String text(){
            return this.text;
        }
    }
}
