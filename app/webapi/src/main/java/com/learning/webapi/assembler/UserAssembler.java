package com.learning.webapi.assembler;

import com.learning.domain.user.Attachment;
import com.learning.domain.user.User;
import com.learning.webapi.vo.UserVo;

/**
 * Created by shenjixiaodao on 2017/12/6.
 */
public class UserAssembler {

    public static User toUser(UserVo vo) {
        User user = new User(vo.getNickname(), vo.getWechatId());
        return user;
    }

    public static Attachment toAttachment(Long uid, String name, String type) {
        Attachment attachment = new Attachment(uid, name, Attachment.Type.typeOf(type));
        return attachment;
    }
}
