package com.github.dotkebi.IUConverter;

/**
 * @author by dotkebi@gmail.com on 2017-01-05.
 */
public class FileSizeConverter {

    public static String convert(long source) {
        FileSizeType unit = FileSizeType.BYTE;

        while (String.valueOf(source).length() > 3 && unit.ordinal() + 1 < FileSizeType.values().length) {
            source = (long) Math.floor(source / FileSizeType.convert);
            unit = FileSizeType.values()[unit.ordinal() + 1];
        }

        return String.format("%,d%s", source, unit.getUnit());
    }

}
