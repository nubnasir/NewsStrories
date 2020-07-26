package com.nubnasir.newsstories.common.model;

/**
 * Created by root on 9/13/18.
 */
public class OperationResponse {

    private int responseCode;
    private String message;

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
