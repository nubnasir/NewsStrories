package com.nubnasir.newsstories.common.enums;

/**
 * Created by root on 9/11/18.
 * <b>Note</b> News stories operation type.
 * Helps to get view title for different operation
 */
public enum OperationType {

    CREATE("Create"),
    EDIT("Edit"),
    DELETE("Delete");

    private String type;

    OperationType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
