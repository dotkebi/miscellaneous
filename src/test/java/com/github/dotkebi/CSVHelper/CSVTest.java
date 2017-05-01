package com.github.dotkebi.CSVHelper;

import com.github.dotkebi.CSVHelper.byInterface.CSVFileWriter;
import com.github.dotkebi.CSVHelper.byStatic.CSVStaticFileWriter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by dotkebi@gmail.com on 2017-5-1.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplication.class)
public class CSVTest {

    @Autowired
    private CSVFileWriter csvFileWriter;

    @Test
    public void writeByStaticTest() {
        CSVStaticFileWriter.convert(getTestData(), "test");

    }

    @Test
    public void writeByInterfaceTest() {
        csvFileWriter.convert(getTestData(), "test");

    }

    private List<TestModel> getTestData() {
        List<TestModel> dataList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            dataList.add(new TestModel(i, "name" + i, 20 + i));
        }
        return dataList;
    }

}
