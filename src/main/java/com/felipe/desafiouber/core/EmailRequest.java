package com.felipe.desafiouber.core;

public record EmailRequest(
    String to,
    String subject,
    String body
) {
    
}
