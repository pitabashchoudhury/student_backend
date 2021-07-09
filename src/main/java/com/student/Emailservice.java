package com.student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Service
public class Emailservice {


    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private SimpleMailMessage simpleMailMessage;


    @Bean
    public SimpleMailMessage emailTemplate()
    {
        SimpleMailMessage message = new SimpleMailMessage();
                return message;
    }

    public String sendMail(String to, String subject, String body) throws MessagingException
    {
        SimpleMailMessage message = new SimpleMailMessage();
        //message.setFrom("pitabashchoudhdry1998@gmail.com");
        message.setFrom("${spring.mail.username}");

        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        javaMailSender.send(message);
        return "yes";
    }
}
