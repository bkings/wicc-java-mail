package com.wicc.javamail.controller;

import com.wicc.javamail.models.Mail;
import com.wicc.javamail.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.mail.MessagingException;

/**
 * @author bkings
 * @version 1.0.0
 * @since 2021-12-31 00:22
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/mail")
public class MailController {
    private final MailService mailService;

    @PostMapping
    public String sendSimpleMail(@ModelAttribute Mail mail) {
        mailService.sendSimpleMessage(mail);
        return "success";
    }

    @PostMapping("/attachment")
    public String sendWithAttachment(@ModelAttribute Mail mail) throws MessagingException {
        mailService.sendMailWithAttachments(mail);
        return "success";
    }
}
