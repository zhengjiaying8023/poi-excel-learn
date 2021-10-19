package com.grace.learn.service.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import com.grace.learn.bo.ExportPoiTemplateBo;
import com.grace.learn.service.EasyPoiService;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Service
@Slf4j
public class EasyPoiServiceImpl implements EasyPoiService {

    @Override
    public void exportBigExcel(HttpServletResponse response) {
        ExportParams exportParams = new ExportParams("导出模板示例", "模板数据", ExcelType.HSSF);
        //exportBigExcel--数据量大超过5W,还在100W以内,数量过百万时建议改csv导出
        try (Workbook workbook = ExcelExportUtil.exportBigExcel(exportParams, ExportPoiTemplateBo.class).write(List.of()).get()) {
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            log.error("导出异常：", e);
        }
    }

    @Override
    public void exportSmallExcel(HttpServletResponse response) {
        ExportParams exportParams = new ExportParams("导出模板示例", "模板数据", ExcelType.HSSF);
        //List.of()---要导出的链表数据
        try (Workbook workbook = ExcelExportUtil.exportExcel(exportParams, ExportPoiTemplateBo.class, List.of())) {
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            log.error("导出异常：", e);
        }
    }
}
