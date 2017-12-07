package com.learning.biz.service;

import com.learning.domain.room.Room;
import com.learning.domain.room.RoomRepository;
import com.learning.domain.service.ElementaryService;
import com.learning.domain.subject.Subject;
import com.learning.domain.subject.SubjectRepository;
import com.learning.domain.user.Attachment;
import com.learning.domain.user.User;
import com.learning.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Created by shenjixiaodao on 2017/11/29.
 */
@Service
public class ElementaryServiceImpl implements ElementaryService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public void createRoom(Room room, Long uid, Integer subjectId) {
        Subject subject = subjectRepository.find(subjectId);
        room.subject(subject);
        User user = userRepository.findUser(uid);
        room.host(user);
        roomRepository.save(room);
    }

    @Override
    @Transactional
    public void joinRoom(Long uid, Long rid) {
        User user = userRepository.findUser(uid);
        Room room = roomRepository.findRoom(rid);
        room.joinRoom(user, roomRepository);
        roomRepository.update(room);
    }

    @Override
    public void registerUser(User user) {
        userRepository.addUser(user);
    }

    @Override
    @Transactional
    public void applyForTeacher(Long userId, List<Long> attachmentIds) {
        User user = userRepository.findUser(userId);
        List<Attachment> attachments = userRepository.findAttachmentsByIds(attachmentIds);
        user.applyForTeacher(attachments, userRepository);
    }

    @Override
    public void approve2Teacher(Long uid) {
        User user = userRepository.findUser(uid);
        user.approved(userRepository);
    }

    @Override
    @Transactional
    public void skilledIn(Long uid, List<Integer> subjectIds) {
        User user = userRepository.findUser(uid);
        List<Subject> subjects = subjectRepository.findByIds(subjectIds);
        for(Subject subject:subjects){
            user.addSkilled(subject, userRepository);
        }
    }

    @Override
    @Transactional
    public void commentTutorship(Long studentId, Long teacherId, Integer star,
                                 @Nullable String keyword, @Nullable String comment) {
        User student = userRepository.findUser(studentId);
        User teacher = userRepository.findUser(teacherId);
        student.comment(teacher, star, keyword, comment, userRepository);
    }

    @Override
    @Transactional
    public void uploadAttachment(Attachment attachment) {
        userRepository.addAttachment(attachment);
    }
}
