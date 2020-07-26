package com.nubnasir.newsstories.common.enums;

/**
 * Created by root on 9/10/18.
 */
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
