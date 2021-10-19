package com.grace.learn.bo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ExportPoiTemplateBo {

    @Excel(fixedIndex = 0, name = "序号", type = 10, isWrap = false, width = 12)
    private Integer id;
    @Excel(fixedIndex = 1, name = "a1", isWrap = false, width = 40)
    private String a1;
    @Excel(fixedIndex = 2, name = "a2", isWrap = false, width = 40)
    private String a2;

    @Excel(fixedIndex = 4, name = "a3", numFormat = "####.####", isWrap = false, width = 15)
    private BigDecimal a3;
    @Excel(fixedIndex = 5, name = "a4", numFormat = "####.####", isWrap = false, width = 15)
    private BigDecimal a4;
    @Excel(fixedIndex = 6, name = "a5", numFormat = "####.####", isWrap = false, width = 15)
    private BigDecimal a5;

    @Excel(fixedIndex = 7, name = "a6", format = "yyyy-MM-dd", isWrap = false, width = 20)
    private LocalDate a6;
    @Excel(fixedIndex = 8, name = "a7", isWrap = false, width = 20)
    private String a7;
}
