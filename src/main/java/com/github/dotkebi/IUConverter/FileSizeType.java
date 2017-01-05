package com.github.dotkebi.IUConverter;

/**
 * @author by myoungjin on 2017-01-05.
 */
public enum FileSizeType {
    BYTE("B")
    , KILOBYTE("KB")
    , MEGABYTE("MB")
    , GIGABYTE("GB")
    , TERABYTE("TB")
    , PETABYTE("PB")
    ;

    public static final int CONVERT = 1000;
    public static final int CONVERT_LENGTH = String.valueOf(CONVERT).length() - 1;

    private String unit;

    FileSizeType(String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }

}
