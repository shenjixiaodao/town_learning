package com.learning.domain;

import java.util.Date;
import java.util.List;

/**
 * Created by jinhui on 2017/11/24.
 */
public class Room {

    private Long id;
    private String name;
    private List<Subject> subjects;
    private Long userId;
    private Date planStartTime;
    private Long duration;
    private String communication;

    public Room(Long id, String name, List<Subject> subjects,
                Long userId, Date planStartTime,
                Long duration, String communication) {
        this.id = id;
        this.name = name;
        this.subjects = subjects;
        this.userId = userId;
        this.planStartTime = planStartTime;
        this.duration = duration;
        this.communication = communication;
    }

    Room() {
        //for orm
    }
}
