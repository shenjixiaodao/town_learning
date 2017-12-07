package com.learning.data.mapper;

import com.learning.domain.subject.Subject;

import java.util.List;

/**
 * Created by shenjixiaodao on 2017/11/27.
 */
public interface SubjectMapper {
    Subject find(Integer id);
    List<Subject> findByIds(List<Integer> ids);
}
