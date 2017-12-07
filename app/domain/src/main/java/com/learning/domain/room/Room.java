package com.learning.domain.room;

import com.learning.domain.subject.Subject;
import com.learning.domain.user.User;
import org.springframework.util.Assert;

import javax.annotation.Nullable;
import java.util.Date;

/**
 * Created by shenjixiaodao on 2017/11/24.
 */
public class Room {

    private Long id;
    private String name;
    private Subject subject;
    private User host;
    private Date planStartTime;
    private Long duration;
    //自定义允许进入人数
    private Integer limitCount;
    //远程通信方式
    private String communication;

    public Room(String name, Date planStartTime, Long duration,
                String communication, @Nullable Integer limitCount) {
        this.name = name;
        this.planStartTime = planStartTime;
        //如果未设置自定义人数限定，则使用课程人数限定
        this.limitCount = limitCount;
        this.duration = duration;
        this.communication = communication;
    }

    public void host(User host) {
        Assert.notNull(host, "用户不存在");
        this.host = host;
    }

    public void subject(Subject subject) {
        Assert.notNull(subject, "科目不存在");
        this.subject = subject;
        //如果未设置自定义人数限定，则使用课程人数限定
        this.limitCount = limitCount == null
                ? subject.limitCount() : limitCount;
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
