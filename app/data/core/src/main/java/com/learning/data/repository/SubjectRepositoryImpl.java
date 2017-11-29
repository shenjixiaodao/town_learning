package com.learning.data.repository;

import com.learning.data.mapper.SubjectMapper;
import com.learning.domain.subject.Subject;
import com.learning.domain.subject.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by shenjixiaodao on 2017/11/29.
 */
@Repository
public class SubjectRepositoryImpl implements SubjectRepository {

    @Autowired
    private SubjectMapper subjectMapper;

    @Override
    public Subject find(Integer id) {
        return subjectMapper.find(id);
    }
}
