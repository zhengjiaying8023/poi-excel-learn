package com.grace.learn.controller;

import com.grace.learn.service.EasyPoiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Api(tags = "easy-poi", value = "easy-poi学习")
@RestController
@RequestMapping("easy/poi")
public class EasyPoiExcelController {

    @Autowired
    private EasyPoiService easyPoiService;

    @ApiOperation("excel大数据量导出")
    @GetMapping("big")
    @ResponseBody
    public void exportBig(HttpServletResponse response) throws IOException {
        //exportBigExcel--数据量大超过5W,还在100W以内,数量过百万时建议改csv导出
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode("学习.xlsx", StandardCharsets.UTF_8));
        response.flushBuffer();
        easyPoiService.exportBigExcel(response);
    }

    @ApiOperation("excel小数据量导出")
    @GetMapping("small")
    @ResponseBody
    public void exportSmall(HttpServletResponse response) throws IOException {
        //数据量小于5万
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode("学习.xlsx", StandardCharsets.UTF_8));
        response.flushBuffer();
        easyPoiService.exportSmallExcel(response);
    }

}
