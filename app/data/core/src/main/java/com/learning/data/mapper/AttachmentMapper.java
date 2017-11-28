package com.learning.data.mapper;

import com.learning.domain.user.Attachment;

/**
 * Created by shenjixiaodao on 2017/11/27.
 */
public interface AttachmentMapper {

    void save(Attachment attachment);
    void update(Attachment attachment);

}
