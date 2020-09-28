package com.nubnasir.newsstories.common.enums;

public enum  DateFlagEnum {

    ALL(0),
    FROM_NOW(1);

    private int code;

    DateFlagEnum(int code){
        this.code = code;
    }

    public int getCode(){
        return this.code;
    }
}
