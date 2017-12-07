package com.learning.domain.room;

import com.learning.domain.user.User;

/**
 * Created by shenjixiaodao on 2017/11/27.
 */
public interface RoomRepository {

    Room findRoom(Long rid);
    void save(Room room);
    void addStudent(Long rid, User student);
    void update(Room room);
}
