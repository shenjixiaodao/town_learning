package com.learning.data.mapper;

import com.learning.domain.room.Room;

/**
 * Created by shenjixiaodao on 2017/11/27.
 */
public interface RoomMapper {
    void save(Room room);
    Room find(Long id);
    void update(Room room);
}
