package com.learning.webapi.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by shenjixiaodao on 2017/12/6.
 */
@RestController
@RequestMapping(value = "/room")
@Api(value = "room", description = "房间相关接口")
public class RoomApi {
}
