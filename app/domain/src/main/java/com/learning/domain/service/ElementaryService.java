package com.learning.domain.service;


import com.learning.domain.room.Room;
import com.learning.domain.subject.Subject;
import com.learning.domain.user.Attachment;
import com.learning.domain.user.User;
import javax.annotation.Nullable;
import java.util.List;

/**
 * Created by shenjixiaodao on 2017/11/28.
 */
public interface ElementaryService {

    //================== room
    void createRoom(Room room, Long uid, Integer subjectId);
    void joinRoom(Long uid, Long rid);

    //================== user
    void registerUser(User user);
    void applyForTeacher(Long userId, List<Long> attachmentIds);
    void approve2Teacher(Long uid);
    void skilledIn(Long uid, List<Integer> subjectIds);
    void commentTutorship(Long studentId, Long teacherId, Integer star,
                          @Nullable String keyword, @Nullable String comment);
    void uploadAttachment(Attachment attachment);
}
