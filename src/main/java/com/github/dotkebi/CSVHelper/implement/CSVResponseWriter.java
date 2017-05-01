package com.github.dotkebi.CSVHelper.implement;

import com.github.dotkebi.CSVHelper.CSVWritable;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author by dotkebi@gmail.com on 2017-04-24.
 */
public class CSVResponseWriter implements CSVWritable {

    public void convert(HttpServletResponse response, List<?> datas, String name) {
        response.addHeader("Content-disposition", "attachment;filename=" + name + ".csv");
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        try {
            write(response.getOutputStream(), transform(datas));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
