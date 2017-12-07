package com.learning.webapi.vo;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by shenjixiaodao on 2017/12/6.
 */
public class ApplicationMaterialVo {

    @ApiModelProperty(value="用户ID", required = true)
    private Long uid;
    @ApiModelProperty(value="附件ids", dataType = "Long", required = true)
    private List<Long> attachmentIds;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public List<Long> getAttachmentIds() {
        return attachmentIds;
    }

    public void setAttachmentIds(List<Long> attachmentIds) {
        this.attachmentIds = attachmentIds;
    }

    @Override
    public String toString() {
        return "ApplicationMaterialVo{" +
                "uid=" + uid +
                ", attachmentIds=" + attachmentIds +
                '}';
    }
}
