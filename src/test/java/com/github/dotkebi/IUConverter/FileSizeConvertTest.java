package com.github.dotkebi.IUConverter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author by dotkebi@gmail.com on 2017-1-5.
 */
public class FileSizeConvertTest {

    @Test
    public void convertTest() {
        assertThat(394838934L, "MB");
        assertThat(139434242424L, "GB");
        assertThat(13948389224342424L, "PB");
        assertThat(139483892243242424L, "PB");
        assertThat(1394838922434242424L, "PB");
    }

    private void assertThat(long source, String unit) {
        String actual = actualPreffix(source) + unit;
        System.out.println(actual);
        assertEquals(FileSizeConverter.convert(source), actual);
    }

    private String actualPreffix(long source) {
        int length = String.valueOf(source).length();
        int targetLength = length % 3;
        if (targetLength == 0) {
            targetLength = 3;
        }
        if (length > FileSizeType.values().length * 3) {
            targetLength += 3;
        }
        return String.valueOf(source).substring(0, targetLength);
    }

}