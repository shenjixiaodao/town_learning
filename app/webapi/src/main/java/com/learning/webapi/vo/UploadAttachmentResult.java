package com.learning.webapi.vo;

import com.learning.webapi.vo.base.WebResult;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by shenjixiaodao on 2017/12/8.
 */
public class UploadAttachmentResult extends WebResult {

    @ApiModelProperty(value="昵称", required = true)
    Long attachmentId;

    public Long getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(Long attachmentId) {
        this.attachmentId = attachmentId;
    }
}
