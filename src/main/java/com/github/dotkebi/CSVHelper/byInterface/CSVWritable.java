package com.github.dotkebi.CSVHelper.byInterface;

import com.github.dotkebi.CSVHelper.CSVConstants;
import com.opencsv.CSVWriter;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author by dotkebi@gmail.com on 2017-04-24.
 */
public interface CSVWritable {

    default void write(OutputStream outputStream, List<?> sources) {
        List<String[]> datas = transform(sources);

        try (
                CSVWriter writer = new CSVWriter(new OutputStreamWriter(outputStream), ',', CSVWriter.NO_QUOTE_CHARACTER)
        ) {
            //add BOM
            outputStream.write(CSVConstants.UTF8_BOM.getBytes());
            writer.writeAll(datas);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    default List<String[]> transform(List<?> objects) {
        List<String[]> dataToWrite = new ArrayList<>();
        if (objects.size() == 0) {
            return dataToWrite;
        }

        dataToWrite.add(makeHeader(objects.get(0).getClass()));

        int i;
        Field[] fields;
        String[] columns;

        for (Object dto : objects) {
            i = 0;
            fields = dto.getClass().getDeclaredFields();
            columns = new String[fields.length];
            for (Field field : fields) {
                field.setAccessible(true);
                try {
                    String data = field.get(dto) == null ? "" : String.valueOf(field.get(dto));
                    columns[i] = data;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                ++i;
            }
            dataToWrite.add(columns);
        }
        return dataToWrite;
    }

    default String[] makeHeader(Class title) {
        Field[] fields = title.getDeclaredFields();
        String[] columns = new String[fields.length];

        int i = 0;
        for (Field field : fields) {
            columns[i] = field.getName();
            ++i;
        }
        return columns;
    }

}
