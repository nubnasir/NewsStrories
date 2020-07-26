package com.nubnasir.newsstories.user.model.dto;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * Created by root on 9/12/18.
 */

public class UserRegistrationDto {

    @NotEmpty(message = "User name is required")
    @Size(min = 4, max = 50, message = "User name must be between four to fifty characters")
    private String userName;

    @NotEmpty(message = "Full Name is required")
    @Size(min = 4, max = 50, message = "Full name must be between four to fifty characters")
    private String fullName;

    @NotEmpty(message = "Password is required")
    @Size(min = 6, max = 50, message = "User name must be between four to fifty characters")
    private String password;

    @NotEmpty(message = "Confirm Password is required")
    private String confirmPassword;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
