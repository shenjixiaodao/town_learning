package com.learning.domain.room;

import com.learning.domain.user.User;
import org.springframework.util.Assert;

import java.util.Date;

/**
 * Created by shenjixiaodao on 2017/11/24.
 */
public class Room {

    private Long id;
    private String name;
    private Subject subject;
    private Long userId;
    //房主昵称
    private String nickname;
    private Date planStartTime;
    private Long duration;
    //自定义允许进入人数
    private Integer limitCount;
    //远程通信方式
    private String communication;

    public Room(Long id, String name, Subject subject,
                Long userId, Date planStartTime, Integer limitCount,
                Long duration, String communication) {
        this.id = id;
        this.name = name;
        this.subject = subject;
        this.userId = userId;
        this.planStartTime = planStartTime;
        //如果未设置自定义人数限定，则使用课程人数限定
        this.limitCount =
                limitCount == null ? subject.limitCount() : limitCount;
        this.duration = duration;
        this.communication = communication;
    }

    public void joinRoom(User student, RoomRepository repository) {
        Assert.isTrue(limitCount > 0 , "人数已满");
        limitCount--;
        repository.addStudent(this.id, student);
    }

    Room() {
        //for orm
    }
}
