package com.ssafy.sandbox.email.service;

import com.ssafy.sandbox.email.dto.EmailAuthRequestDto;
import com.ssafy.sandbox.email.dto.EmailRequestDto;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
@Slf4j
public class EmailServiceImpl implements EmailService {
    @Value("${spring.mail.username}")
    private String fromEmail;
    private final JavaMailSender mailSender;
    private final Map<String, String> authCodeStorage = new HashMap<>();


    public EmailServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public boolean sendEmailAuthCode(EmailRequestDto emailRequestDto) {
        String email = emailRequestDto.getEmail();
        String authCode = generateAuthCode();
        authCodeStorage.put(email, authCode);

        try {
            sendEmail(email, authCode);
            return true;
        } catch (MessagingException e) {
            log.error("Failed to Send Email to: {}", email);
            return false;
        }

    }

    @Override
    public boolean verifyEmailAuthCode(EmailAuthRequestDto emailAuthRequestDto) {
        String toEmail = emailAuthRequestDto.getEmail();
        String authCode = emailAuthRequestDto.getAuthentication();
        return authCode.equals(authCodeStorage.getOrDefault(toEmail, ""));
    }

    private String generateAuthCode() {
        int code = new Random().nextInt(1000000);
        return String.format("%06d", code);
    }

    private void sendEmail(String to, String authCode) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        // 이메일 설정
        helper.setFrom(fromEmail);
        helper.setTo(to);
        helper.setSubject("이메일 인증 코드");
        helper.setText("인증 코드:\n" + authCode);

        // 이메일 발송
        mailSender.send(message);
    }
}
