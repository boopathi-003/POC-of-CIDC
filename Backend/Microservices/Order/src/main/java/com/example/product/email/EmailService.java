package com.example.product.email;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String adminMail;



    public void sendOrderConfirmationEmail(String to, String orderDetails) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);

        try {
            messageHelper.setFrom(adminMail);
            messageHelper.setTo(to);
            messageHelper.setSubject("Order Confirmation");
            messageHelper.setText("Your order has been placed successfully. Order Details: \n\n" + orderDetails);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();

        }
    }
}

