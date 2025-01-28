package com.example.microservice1.mail;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Objects;

@Service
public class EmailServiceWithAtachment {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String fromEmail;

    public void sendWithAttachment(String to, String subject, String body, String attachment) throws MessagingException {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);


        mimeMessageHelper.setFrom(fromEmail);

        mimeMessageHelper.setTo(to);

        mimeMessageHelper.setSubject(subject);

        mimeMessageHelper.setText(body);


        FileSystemResource file = new FileSystemResource(new File(attachment));
        if (file.exists()) {

            mimeMessageHelper.addAttachment(Objects.requireNonNull(file.getFilename()), file);
        } else {
            throw new MessagingException("Attachment file not found at the specified path.");
        }


        javaMailSender.send(mimeMessage);
    }
}
