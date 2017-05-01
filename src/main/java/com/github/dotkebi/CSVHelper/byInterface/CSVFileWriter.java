package com.github.dotkebi.CSVHelper.byInterface;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * @author by dotkebi@gmail.com on 2017-04-24.
 */
@Component
public class CSVFileWriter implements CSVWritable {

    public void convert(List<?> datas, String name) {
        if (!name.endsWith(".csv")) {
            name += ".csv";
        }

        File file = new File(name);
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            write(fileOutputStream, datas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
