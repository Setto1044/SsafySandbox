package com.ssafy.sandbox.email.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailRequestDto {
    @NotBlank
    @Email
    private String email;

    /*
    private EmailRequestDto(String email){
        this.email = email;
    }
    public static EmailRequestDto of(String email) {
        if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new IllegalArgumentException("요청이 정상적으로 처리되지 않았습니다.");
        }
        return new EmailRequestDto(email);
    }
    */
}
