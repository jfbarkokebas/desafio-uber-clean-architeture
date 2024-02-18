package com.felipe.desafiouber.infra.ses;

import org.springframework.stereotype.Service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;
import com.felipe.desafiouber.adapters.EmailSenderGateway;
import com.felipe.desafiouber.core.exceptions.EmailServiceException;

@Service
public class SesEmailSender implements EmailSenderGateway {

    private final AmazonSimpleEmailService amzSes;


    public SesEmailSender(AmazonSimpleEmailService amzSes) {
        this.amzSes = amzSes;
    }

    @Override
    public void sendEmail(String to, String subject, String body) {
        SendEmailRequest request = new SendEmailRequest()
              .withSource("jfdeveloper2024@gmail.com")  
              .withDestination(new Destination().withToAddresses(to))
              .withMessage(new Message()
                    .withSubject(new Content(subject))
                    .withBody(new Body().withText(new Content(body))) 
              );

              try {
                
                amzSes.sendEmail(request);

              } catch (AmazonServiceException exception) {
                  
                throw new EmailServiceException("Failure while sending email", exception);
              }

    }
    

}
