package com.learning.domain.user;

import com.learning.domain.subject.Subject;

import java.util.List;

/**
 * Created by jinhui on 2017/11/27.
 */
public interface UserRepository {

    void addUser(User user);
    User findUser(Long uid);
    void updateUser(User user);
    void addAttachment(Attachment attachment);
    /**
     * 将上传成功的附件正式地绑定到{@link User}上
     * @param attachment
     */
    void bindAttachment(Attachment attachment);
    List<Attachment> findAttachmentsByIds(List<Long> ids);

    void addSkilledSubject(Long uid, Subject subject);

    void addComment(Comment comment);
}
