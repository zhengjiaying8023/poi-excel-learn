package com.grace.learn.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "首页信息管理", value = "测试")
@RestController
@RequestMapping("/home")
public class HomeController {

    @ApiOperation("首页详情")
    @GetMapping("/home")
    public String home() {
        return "true---成功";
    }
}
