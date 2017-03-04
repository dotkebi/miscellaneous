package com.github.dotkebi.IUConverter;

/**
 * @author by dotkebi@gmail.com on 2017-2-12.
 */
public enum SizeType {
    BIT("B")
    , KILOBIT("KB")
    , MEGABIT("MB")
    , GIGABIT("GB")
    , TERABIT("TB")
    , PETABIT("PB")
    ;

    public static final int CONVERT = 1000;
    public static final int CONVERT_LENGTH = String.valueOf(CONVERT).length() - 1;

    private String unit;

    SizeType(String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }

}
