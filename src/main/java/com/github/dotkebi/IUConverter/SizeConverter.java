package com.github.dotkebi.IUConverter;

/**
 * @author by dotkebi@gmail.com on 2017-02-12.
 */
public class SizeConverter {

    public static String convert(long source) {
        SizeType unit = SizeType.BIT;

        while (String.valueOf(source).length() > SizeType.CONVERT_LENGTH
                && unit.ordinal() + 1 < SizeType.values().length) {
            source = (long) Math.floor(source / SizeType.CONVERT);
            unit = SizeType.values()[unit.ordinal() + 1];
        }

        return String.format("%,d%s", source, unit.getUnit());
    }

}
