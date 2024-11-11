package com.ssafy.sandbox.email.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailAuthRequestDto {
    @NotBlank
    @Pattern(regexp = "^[0-9]{6}$")
    private String authentication;

    @NotBlank
    @Email
    private String email;
}
