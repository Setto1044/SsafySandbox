package com.ssafy.sandbox.email.controller;

import com.ssafy.sandbox.email.dto.EmailAuthRequestDto;
import com.ssafy.sandbox.email.dto.EmailAuthResponseDto;
import com.ssafy.sandbox.email.dto.EmailRequestDto;
import com.ssafy.sandbox.email.dto.EmailSendResponseDto;
import com.ssafy.sandbox.email.service.EmailService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
public class EmailController {
    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping
    public ResponseEntity<EmailSendResponseDto> sendEmail(@RequestBody @Valid EmailRequestDto emailRequest) {
        boolean isOk = emailService.sendEmailAuthCode(emailRequest);
        EmailSendResponseDto emailSendResponseDto = EmailSendResponseDto.of(isOk);
        return ResponseEntity.ok(emailSendResponseDto);
    }

    @PostMapping("/authentication")
    public ResponseEntity<EmailAuthResponseDto> verifyAuthCode(@RequestBody @Valid EmailAuthRequestDto emailAuthRequest) {
        boolean isSuccess = emailService.verifyEmailAuthCode(emailAuthRequest);
        EmailAuthResponseDto emailAuthResponseDto = EmailAuthResponseDto.of(isSuccess);
        return ResponseEntity.ok(emailAuthResponseDto);
    }
}
