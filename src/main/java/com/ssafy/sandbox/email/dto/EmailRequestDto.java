package com.ssafy.sandbox.email.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class EmailRequestDto {
    @NotBlank
    @Email
    private String email;

    private LocalDateTime authExpireDate;
    private String authCode;
}
