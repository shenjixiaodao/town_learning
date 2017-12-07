package com.learning.domain.subject;

import java.util.List;

/**
 * Created by shenjixiaodao on 2017/11/29.
 */
public interface SubjectRepository {
    Subject find(Integer id);
    List<Subject> findByIds(List<Integer> ids);
}
