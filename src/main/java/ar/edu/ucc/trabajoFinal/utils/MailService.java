/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.ucc.trabajoFinal.utils;

import java.nio.charset.StandardCharsets;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 *
 * @author ezequiel
 */
@Service
public class MailService {

    private JavaMailSenderImpl mailSender;
    

    public void setMailSender(JavaMailSenderImpl mailSender) {
        this.mailSender = mailSender;
    }

    public void send(String from, String to, String subject, String text) throws MessagingException {
        MimeMessage message = buildMimeMessage(from, to, subject);
        message.setContent(text, "text/html; charset=utf-8");
        
        this.mailSender.send(message);

    }
    
    public MimeMessage buildMimeMessage(String from, String to, String subject) {
        
        MimeMailMessage builder = mimeBuilder();
        builder.setFrom(from);
        builder.setTo(to);
        builder.setSubject(subject);
        
        return builder.getMimeMessage();
    }
    
    private MimeMailMessage mimeBuilder() {
        MimeMessageHelper helper = new MimeMessageHelper(
                                        mailSender.createMimeMessage(),
                                        StandardCharsets.UTF_8.name());
        return new MimeMailMessage(helper);
    }

}
