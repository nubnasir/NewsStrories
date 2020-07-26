package com.nubnasir.newsstories.common.enums;

/**
 * Created by root on 9/10/18.
 */
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
