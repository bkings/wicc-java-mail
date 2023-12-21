package com.wicc.javamail.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

/**
 * @author bkings
 * @version 1.0.0
 * @since 2021-12-30 23:54
 */
@Configuration
public class EmailConfig {

//    @Value("${email.username}")
    private String email = "myemail@email.com";
//    @Value("${email.password}")
    private String password = "myPassword";

    @Bean
    public JavaMailSender getJavaMailSender() {
        // Specifying mail properties
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost("smtp.gmail.com");
        javaMailSender.setPort(587);
        javaMailSender.setUsername(email);
        javaMailSender.setPassword(password);

        Properties props = javaMailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
        return javaMailSender;
    }

    @Bean
    public SimpleMailMessage templateSimpleMessage() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        // Use of html tags to send an html email.
        simpleMailMessage.setText("<b>This is an automated mail message.</b><br/> Please do not bother to reply. Thank You");
        return simpleMailMessage;
    }

}
