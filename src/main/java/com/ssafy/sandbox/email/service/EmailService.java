package com.ssafy.sandbox.email.service;

import com.ssafy.sandbox.email.dto.EmailAuthRequestDto;
import com.ssafy.sandbox.email.dto.EmailRequestDto;

public interface EmailService {
    boolean sendEmailAuthCode(EmailRequestDto emailRequestDto);

    boolean verifyEmailAuthCode(EmailAuthRequestDto emailAuthRequestDto);
}
