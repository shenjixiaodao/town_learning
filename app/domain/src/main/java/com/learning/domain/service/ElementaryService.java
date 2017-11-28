package com.learning.domain.service;


import com.learning.domain.user.Attachment;
import com.learning.domain.user.User;
import javax.annotation.Nullable;

/**
 * Created by shenjixiaodao on 2017/11/28.
 */
public interface ElementaryService {

    void commentTutorship(User student, User teacher, Integer star,
                          @Nullable String keyword, @Nullable String comment);
    void uploadAttachment(String name, String parentDir, Attachment.Type type);
}
