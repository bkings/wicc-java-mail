package com.wicc.javamail.service.impl;

import com.wicc.javamail.models.Mail;
import com.wicc.javamail.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @author bkings
 * @version 1.0.0
 * @since 2021-12-31 00:05
 */
@RequiredArgsConstructor
@Service
public class MailServiceImpl implements MailService {

    private final JavaMailSender javaMailSender;
    @Value("${email.username}")
    private String email;

    @Override
    public String sendSimpleMessage(Mail mail) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(email);
        simpleMailMessage.setTo(mail.getTo());
        simpleMailMessage.setSubject(mail.getSubject());
        simpleMailMessage.setText(mail.getText());
        javaMailSender.send(simpleMailMessage);
        return "Success";
    }

    @Override
    public void sendMailWithAttachments(Mail mail) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setFrom(email);
        mimeMessageHelper.setTo(mail.getTo());
        mimeMessageHelper.setSubject(mail.getSubject());
        mimeMessageHelper.setText(mail.getText());
        mail.getAttachments().forEach(f -> {
            try {
                mimeMessageHelper.addAttachment("File", f);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        });
        javaMailSender.send(mimeMessage);
    }
}
