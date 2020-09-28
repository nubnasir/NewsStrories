package com.nubnasir.newsstories.user.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private long id;
    private String userName;
    private String fullName;
    private String registrationDate;
    private String lastLoginDate;
}
