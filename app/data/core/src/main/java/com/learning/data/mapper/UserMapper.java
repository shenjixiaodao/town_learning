package com.learning.data.mapper;

import com.learning.domain.user.User;

import java.util.Map;

/**
 * Created by shenjixiaodao on 2017/11/27.
 */
public interface UserMapper {

    void save(User user);
    void update(User user);
    void addSkilled(Map paras);
}
