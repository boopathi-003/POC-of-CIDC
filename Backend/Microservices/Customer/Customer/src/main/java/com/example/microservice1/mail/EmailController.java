package com.example.microservice1.mail;

import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;
    @Autowired
    private EmailServiceWithAtachment emailServiceWithAtachment;

    @PostMapping("/send")
    public String sendEmail(
            @RequestParam String to,
            @RequestParam String subject,
            @RequestParam String body) {
        emailService.sendSimpleEmail(to, subject, body);
        return "Email sent successfully!";
    }

    @PostMapping("/sendwithattachment")
    public String sendWithAttachment(  @RequestParam String to,
                                       @RequestParam String subject,
                                       @RequestParam String body,
                                       @RequestParam String attachment) throws MessagingException {
        emailServiceWithAtachment.sendWithAttachment(to,subject,body,attachment);
        return "Email sent successfully!";
    }
}
