package com.wicc.javamail.service;

import com.wicc.javamail.models.Mail;

import javax.mail.MessagingException;

/**
 * @author bkings
 * @version 1.0.0
 * @since 2021-12-30 10:18
 */

public interface MailService {

    String sendSimpleMessage(Mail mail);

    void sendMailWithAttachments(Mail mail) throws MessagingException;

    void sendFromATemplate(Mail mail) throws MessagingException;
}
