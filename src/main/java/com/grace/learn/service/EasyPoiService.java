package com.grace.learn.service;

import javax.servlet.http.HttpServletResponse;

public interface EasyPoiService {

    void exportBigExcel(HttpServletResponse response);

    void exportSmallExcel(HttpServletResponse response);
}
