package com.nubnasir.newsstories.common.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class OperationResponse {
    private int responseCode;
    private String message;
}
