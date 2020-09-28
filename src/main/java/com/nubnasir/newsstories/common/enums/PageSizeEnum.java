package com.nubnasir.newsstories.common.enums;

/**
 * <b>Note</b> for number of news stories in a page
 */
public enum PageSizeEnum {
    TWO(2),
    FOUR(4),
    SIX(6),
    EIGHT(8),
    TEN(10);

    private int code;

    PageSizeEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
