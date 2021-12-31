package com.wicc.javamail.service;

import com.wicc.javamail.models.Mail;

/**
 * @author bkings
 * @version 1.0.0
 * @since 2021-12-30 10:18
 */

public interface MailService {

    String sendSimpleMessage(Mail mail);
}
