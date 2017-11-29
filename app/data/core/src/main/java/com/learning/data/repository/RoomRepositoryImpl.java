package com.learning.data.repository;

import com.learning.data.mapper.ClassmateMapper;
import com.learning.data.mapper.RoomMapper;
import com.learning.domain.room.Room;
import com.learning.domain.room.RoomRepository;
import com.learning.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shenjixiaodao on 2017/11/27.
 */
@Repository
public class RoomRepositoryImpl implements RoomRepository{

    @Autowired
    private RoomMapper roomMapper;
    @Autowired
    private ClassmateMapper classmateMapper;

    @Override
    public Room findRoom(Long rid) {
        return roomMapper.find(rid);
    }

    @Override
    public void save(Room room) {
        roomMapper.save(room);
    }

    @Override
    public void addStudent(Long rid, User student) {
        Map<String, Object> paras = new HashMap<>();
        paras.put("roomId", rid);
        paras.put("student", student);
        classmateMapper.save(paras);
    }

    @Override
    public void update(Room room) {
        roomMapper.update(room);
    }
}
