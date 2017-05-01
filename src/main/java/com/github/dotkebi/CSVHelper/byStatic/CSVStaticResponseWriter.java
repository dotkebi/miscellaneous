package com.github.dotkebi.CSVHelper.byStatic;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author by dotkebi@gmail.com on 2017-04-24.
 */
public class CSVStaticResponseWriter {

    public static void convert(HttpServletResponse response, List<?> datas, String name) {
        response.addHeader("Content-disposition", "attachment;filename=" + name + ".csv");
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        try {
            EntityToCSVConvert.write(response.getOutputStream(), datas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
