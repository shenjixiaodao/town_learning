package com.learning.data.repository;

import com.learning.data.mapper.AttachmentMapper;
import com.learning.data.mapper.CommentMapper;
import com.learning.data.mapper.UserMapper;
import com.learning.domain.subject.Subject;
import com.learning.domain.user.Attachment;
import com.learning.domain.user.Comment;
import com.learning.domain.user.User;
import com.learning.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by shenjixiaodao on 2017/11/27.
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private AttachmentMapper attachmentMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public void addUser(User user) {
        userMapper.save(user);
    }

    @Override
    public User findUser(Long uid) {
        return userMapper.find(uid);
    }

    @Override
    public void addAttachment(Attachment attachment) {
        if(StringUtils.isEmpty(attachment.location())) {
            throw new IllegalArgumentException("附件存放路径为空");
        }
        attachmentMapper.save(attachment);
    }

    @Override
    public void bindAttachment(Attachment attachment) {
        attachmentMapper.update(attachment);
    }

    @Override
    public List<Attachment> findAttachmentsByIds(List<Long> ids) {
        return attachmentMapper.findAttachmentsByIds(ids);
    }

    @Override
    public void updateUser(User user) {
        userMapper.update(user);
    }

    @Override
    public void addSkilledSubject(Long uid, Subject subject) {
        Map<String ,Object> paras = new HashMap<>();
        paras.put("userId", uid);
        paras.put("subject", subject);
        userMapper.addSkilled(paras);
    }

    @Override
    public void addComment(Comment comment) {
        commentMapper.add(comment);
    }
}
