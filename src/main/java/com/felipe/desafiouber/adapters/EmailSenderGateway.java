package com.felipe.desafiouber.adapters;

public interface EmailSenderGateway {
    
    void sendEmail(String to, String subject, String body);
}
