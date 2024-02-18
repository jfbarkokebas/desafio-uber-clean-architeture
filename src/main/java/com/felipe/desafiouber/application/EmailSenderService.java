package com.felipe.desafiouber.application;

import org.springframework.stereotype.Service;

import com.felipe.desafiouber.adapters.EmailSenderGateway;
import com.felipe.desafiouber.core.EmailSenderUseCase;

@Service
public class EmailSenderService implements EmailSenderUseCase{

    private final EmailSenderGateway emailSenderGateway;
    

    public EmailSenderService(EmailSenderGateway emailGateway) {
        this.emailSenderGateway = emailGateway;
    }



    @Override
    public void sendEmail(String to, String subject, String body) {
        this.emailSenderGateway.sendEmail(to, subject, body);
    }

}
