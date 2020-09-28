package com.nubnasir.newsstories.common.enums;

public enum ResponseCodeEnum {
    SUCCESS(100),
    FAILED(103);

    private int code;

    ResponseCodeEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
