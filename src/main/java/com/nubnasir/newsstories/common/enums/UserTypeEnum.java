package com.nubnasir.newsstories.common.enums;

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
