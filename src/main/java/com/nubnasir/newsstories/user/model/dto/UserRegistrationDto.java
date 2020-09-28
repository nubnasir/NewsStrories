package com.nubnasir.newsstories.user.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

@Getter
@Setter
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
}
