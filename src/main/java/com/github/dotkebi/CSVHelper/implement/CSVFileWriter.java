package com.github.dotkebi.CSVHelper.implement;

import com.github.dotkebi.CSVHelper.CSVWritable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * @author by dotkebi@gmail.com on 2017-04-24.
 */
public class CSVFileWriter implements CSVWritable {

    public void convert(List<?> datas, String name) {
        if (!name.endsWith(".csv")) {
            name += ".csv";
        }

        File file = new File(name);
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            write(fileOutputStream, transform(datas));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
