package com.learning.domain.user;

import com.learning.domain.room.Subject;
import org.springframework.util.Assert;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Created by shenjixiaodao on 2017/11/24.
 */
public class User {
    private Long id;
    private String nickname;
    private String wechatId;
    private Role role;
    private List<Subject> beSkilledIn;
    private List<Attachment> attachments;
    private List<Comment> comments;

    public User(String nickname, String wechatId) {
        this.nickname = nickname;
        this.wechatId = wechatId;
        this.role = Role.Student;
    }

    /**
     * 申请成为老师必须上传身份证照片 和 至少一项资历证明
     * ，并且需要对材料进行审核通过后，{@param role}才会赋值为{@link Role#Teacher}
     * @param attachments
     */
    public void applyForTeacher(List<Attachment> attachments, UserRepository repository) {
        Assert.notNull(attachments, "附件为空");
        Assert.isTrue(attachments.size() > 1, "需要包括身份证明和至少一份资历证明");
        Assert.isTrue(hasIdentity(attachments), "缺少身份证明");
        for(Attachment attachment:attachments) {
            //将上传的附件材料关联上用户，用于审核
            attachment.associated();
            repository.bindAttachment(attachment);
        }
    }
    private static boolean hasIdentity(List<Attachment> attachments) {
        for (Attachment attachment : attachments){
            if(attachment.type().isIdentity())
                return true;
        }
        return false;
    }

    public void addAttachment(String name, String parentDir, Attachment.Type type,
                              UserRepository repository) {
        Attachment attachment = new Attachment(this.id, name, type);
        String location = attachment.fileLocation(parentDir);
        attachment.location(location);
        repository.addAttachment(attachment);
    }

    /**
     * 审核通过，角色转为{@link Role#Teacher}
     */
    public void approved(UserRepository repository) {
        this.role = Role.Teacher;
        this.nickname = null;
        repository.updateUser(this);
    }

    /**
     * 添加擅长科目
     * @param subject
     */
    public void addSkilled(Subject subject, UserRepository repository) {
        repository.addSkilledSubject(this.id, subject);
    }

    /**
     * 对{@link Role#Teacher}发表评论
     */
    public void comment(User teacher, Integer star,
                        @Nullable String keyword, @Nullable String comm, UserRepository repository) {
        Comment comment = new Comment(this.id, teacher.id(), star);
        comment.keyword(keyword);
        comment.comment(comm);
        repository.addComment(comment);
    }

    public User nickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public Long id() {
        return id;
    }

    public String nickname() {
        return nickname;
    }

    public String wechatId() {
        return wechatId;
    }

    public Role role() {
        return role;
    }

    public enum  Role {
        Student("学生"), Teacher("老师");
        private String text;
        Role(String text) {
            this.text = text;
        }
        public String text() {
            return this.text;
        }
    }
}
