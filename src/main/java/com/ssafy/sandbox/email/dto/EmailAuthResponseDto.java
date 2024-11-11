package com.ssafy.sandbox.email.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailAuthResponseDto {
    private Boolean isSuccess;

    private EmailAuthResponseDto(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public static EmailAuthResponseDto of(boolean isSuccess) {
        return new EmailAuthResponseDto(isSuccess);
    }
}
