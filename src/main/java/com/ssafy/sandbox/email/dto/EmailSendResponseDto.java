package com.ssafy.sandbox.email.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailSendResponseDto {
    private Boolean isOk;

    private EmailSendResponseDto(boolean isOk) {
        this.isOk = isOk;
    }

    public static EmailSendResponseDto of(boolean isOk) {
        return new EmailSendResponseDto(isOk);
    }
}
