package com.nubnasir.newsstories.authentication.model.dto;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by root on 9/12/18.
 */
public class LoginDto {

    private String j_username;

    private String j_password;

    public String getJ_username() {
        return j_username;
    }

    public void setJ_username(String j_username) {
        this.j_username = j_username;
    }

    public String getJ_password() {
        return j_password;
    }

    public void setJ_password(String j_password) {
        this.j_password = j_password;
    }
}
