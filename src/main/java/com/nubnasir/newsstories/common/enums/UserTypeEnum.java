package com.nubnasir.newsstories.common.enums;

/**
 * Created by root on 9/13/18.
 */
public enum UserTypeEnum {
    AUTHENTICATED(1),
    ANONYMOUS(-1);

    private int code;

    UserTypeEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
