package com.learning.webapi.controller;

import com.learning.domain.service.ElementaryService;
import com.learning.domain.user.Attachment;
import com.learning.domain.user.User;
import com.learning.webapi.assembler.UserAssembler;
import com.learning.webapi.vo.ApplicationMaterialVo;
import com.learning.webapi.vo.UserVo;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

    @ApiOperation(value = "通过审核", response = WebResult.class, httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "uid", dataType = "Long", required = true, value = "用户ID")
    })
    @ResponseBody
    @RequestMapping(value = "/approve2Teacher", method = GET)
    public void approve2Teacher(Long uid) {

    }

    public void skilledIn(Long uid, List<Integer> subjectIds) {

    }

    public void commentTutorship(Long studentId, Long teacherId, Integer star,
                          String keyword,  String comment) {

    }

    @ApiOperation(value = "上传附件", response = WebResult.class, httpMethod = "GET")
    /*@ApiImplicitParams({
            @ApiImplicitParam(paramType = "form", name = "multipartFile", dataType = "file", required = true, value = "文件对象"),
            @ApiImplicitParam(paramType = "query", name = "uid", dataType = "long", required = true, value = "用户ID"),
            @ApiImplicitParam(paramType = "query", name = "type", dataType = "string", required = true, value = "附件类型")
    })*/
    @ResponseBody
    @RequestMapping(value = "/uploadAttachment", method = GET)
    public WebResult uploadAttachment(MultipartFile multipartFile, Long uid, String type) {
        if(logger.isInfoEnabled()) {
            logger.info("上传附件========");
        }
        String srcFilename = multipartFile.getOriginalFilename();
        String name = Attachment.toStoreFilename(srcFilename);
        Attachment attachment = UserAssembler.toAttachment(uid, name, type);
        String location = attachment.fileLocation(attachmentsDir);
        attachment.location(location);
        File destFile = new File(location);
        try {
            multipartFile.transferTo(destFile);
            elementaryService.uploadAttachment(attachment);
        } catch (IOException e) {
            logger.warn("附件上传失败 : {}", e);
            return WebResult.failureResult(e.getMessage());
        }
        return WebResult.successResult();
    }

}
