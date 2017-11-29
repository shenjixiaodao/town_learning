package com.learning.biz.test;

import com.learning.domain.room.Room;
import com.learning.domain.subject.Subject;
import com.learning.domain.service.ElementaryService;
import com.learning.domain.user.User;
import com.learning.domain.user.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * Created by shenjixiaodao on 2017/11/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml", "classpath*:META-INF/spring/*.xml" })
public class ElementaryServiceTest {

    @Autowired
    private ElementaryService service;

    @Test
    public void createRoom(){
        Room room = new Room("打豆豆", new Date(), 1L, "QQ:972249598", 10);
        service.createRoom(room, 1L, 1);
    }


}
