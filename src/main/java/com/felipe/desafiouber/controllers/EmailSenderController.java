package com.felipe.desafiouber.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipe.desafiouber.application.EmailSenderService;

@RestController
@RequestMapping("/api/email")
public class EmailSenderController {

    private final EmailSenderService emailSenderService;

    public EmailSenderController(EmailSenderService emailService) {
        this.emailSenderService = emailService;
    }

    
    
}
