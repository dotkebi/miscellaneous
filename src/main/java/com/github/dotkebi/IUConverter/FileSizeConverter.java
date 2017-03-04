package com.github.dotkebi.IUConverter;

/**
 * @author by dotkebi@gmail.com on 2017-01-05.
 */
public class FileSizeConverter {

    public static String convert(long source) {
        return convert("%,d%s", source);
    }

    public static String convert(String numberFormat, double source) {
        FileSizeType unit = getInitialSizeType();

        while (String.valueOf(source).length() > FileSizeType.CONVERT_LENGTH
                && unit.ordinal() + 1 < FileSizeType.values().length) {
            source = (long) Math.floor(source / FileSizeType.CONVERT);
            unit = FileSizeType.values()[unit.ordinal() + 1];
        }

        return String.format(numberFormat, source, unit.getUnit());
    }

    public static FileSizeType getInitialSizeType() {
        return FileSizeType.BYTE;
    }

}
