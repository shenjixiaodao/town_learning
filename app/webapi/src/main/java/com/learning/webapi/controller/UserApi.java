package com.learning.webapi.controller;

import com.learning.domain.service.ElementaryService;
import com.learning.domain.user.Attachment;
import com.learning.domain.user.User;
import com.learning.webapi.assembler.UserAssembler;
import com.learning.webapi.vo.*;
import com.learning.webapi.vo.base.WebConstants;
import com.learning.webapi.vo.base.WebResult;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by shenjixiaodao on 2017/12/6.
 */
@RestController
@RequestMapping(value = "/user")
@Api(value = "user", description = "用户相关接口")
public class UserApi {

    private static Logger logger = LoggerFactory.getLogger(UserApi.class);

    @Value("${attachment.file.location}")
    private String attachmentsDir;

    @Autowired
    private ElementaryService elementaryService;

    @ApiOperation(value = "注册用户", response = WebResult.class, httpMethod = "POST")
    @ResponseBody
    @RequestMapping(value = "/register", method = POST)
    public WebResult registerUser(@ApiParam(value = "用户信息", required = true) @RequestBody UserVo userVo) {
        if(logger.isInfoEnabled()) {
            logger.info("用户注册 : {}", userVo);
        }
        User user = UserAssembler.toUser(userVo);
        try {
            elementaryService.registerUser(user);
        } catch (Exception ex) {
            logger.warn("注册用户异常: {}", ex);
            return WebResult.failureResult(ex.getMessage());
        }
        return WebResult.successResult();
    }

    @ApiOperation(value = "成为辅导员", response = WebResult.class, httpMethod = "POST")
    @ResponseBody
    @RequestMapping(value = "/applyForTeacher", method = POST)
    public WebResult applyForTeacher(@ApiParam(value = "申请材料信息", required = true)
                                    @RequestBody ApplicationMaterialVo materialVo){
        if(logger.isInfoEnabled()) {
            logger.info("成为辅导员 : {}", materialVo);
        }
        try {
            elementaryService.applyForTeacher(materialVo.getUid(), materialVo.getAttachmentIds());
        } catch (Exception ex) {
            logger.warn("请求成为辅导员异常: {}", ex);
            return WebResult.failureResult(ex.getMessage());
        }
        return WebResult.successResult();
    }

    @ApiOperation(value = "人工审核通过教辅申请", response = WebResult.class, httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "uid", dataType = "Long", required = true, value = "用户ID")
    })
    @ResponseBody
    @RequestMapping(value = "/approve2Teacher", method = GET)
    public WebResult approve2Teacher(Long uid) {
        if(logger.isInfoEnabled()) {
            logger.info("审核通过教辅申请:teacherId={}", uid);
        }
        try {
            elementaryService.approve2Teacher(uid);
        } catch (Exception ex) {
            logger.warn("审核错误: {}", ex);
            return WebResult.failureResult(ex.getMessage());
        }
        return WebResult.successResult();
    }

    @ApiOperation(value = "擅长科目", response = WebResult.class, httpMethod = "POST")
    @ResponseBody
    @RequestMapping(value = "/skilledIn", method = POST)
    public WebResult skilledIn(@ApiParam(value = "擅长科目", required = true)
                              @RequestBody SkilledVo skilledVo) {
        if(logger.isInfoEnabled()) {
            logger.info("擅长科目:{}", skilledVo);
        }
        try {
            elementaryService.skilledIn(skilledVo.getUid(), skilledVo.getSubjectIds());
        } catch (Exception ex) {
            logger.warn("记录擅长科目错误: {}", ex);
            return WebResult.failureResult(ex.getMessage());
        }
        return WebResult.successResult();
    }

    @ApiOperation(value = "教学评论", response = WebResult.class, httpMethod = "POST")
    @ResponseBody
    @RequestMapping(value = "/commentTutorship", method = POST)
    public WebResult commentTutorship(@ApiParam(value = "评论内容", required = true)
                                          @RequestBody TutorshipCommentVo commentVo) {
        try {
            elementaryService.commentTutorship(commentVo.getStudentId(),
                    commentVo.getTeacherId(), commentVo.getStar(),
                    commentVo.getKeyword(), commentVo.getComment());
        } catch (Exception ex) {
            logger.warn("教学评论出错: {}", ex);
            return WebResult.failureResult(ex.getMessage());
        }
        return WebResult.successResult();
    }

    @ApiOperation(value = "上传附件", response = UploadAttachmentResult.class, httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "form", name = "multipartFile", dataType = "file", required = true, value = "文件对象"),
            @ApiImplicitParam(paramType = "form", name = "uid", dataType = "long", required = true, value = "用户ID"),
            @ApiImplicitParam(paramType = "form", name = "type", dataType = "string", required = true, value = "附件类型")
    })
    @ResponseBody
    @RequestMapping(value = "/uploadAttachment", method = POST)
    public UploadAttachmentResult uploadAttachment(MultipartFile multipartFile, Long uid, String type) {
        if(logger.isInfoEnabled()) {
            logger.info("上传附件========");
        }
        UploadAttachmentResult result = new UploadAttachmentResult();
        String srcFilename = multipartFile.getOriginalFilename();
        String name = Attachment.toStoreFilename(srcFilename);
        Attachment attachment = UserAssembler.toAttachment(uid, name, type);
        String location = attachment.fileLocation(attachmentsDir);
        attachment.location(location);
        File destFile = new File(location);
        try {
            multipartFile.transferTo(destFile);
            elementaryService.uploadAttachment(attachment);
            result.setResultCode(WebConstants.RESULT_SUCCESS_CODE);
            result.setAttachmentId(attachment.id());
        } catch (IOException e) {
            logger.warn("附件上传失败 : {}", e);
            result.setResultCode(WebConstants.RESULT_SUCCESS_CODE);
            result.setMessage(e.getMessage());
            return result;
        }
        return result;
    }

}
