package com.example.service;

import java.io.File;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.component.ContentMail;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class DispatchMailService {


	private JavaMailSender mailsender;
	
	public DispatchMailService(JavaMailSender mailsender) {
		this.mailsender = mailsender;
	}
	
	public void sendMail(ContentMail content) throws MessagingException {
		
		MimeMessage message = mailsender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		
		helper.setSubject("Testing Mails from Spring Boot");
		helper.setFrom("franko200ng@gmail.com");
		helper.setTo(content.getReceipient());
		
		helper.setText(content.getContent(), true);
		
		mailsender.send(message);
		
		
	}
	
	public void sendMailWithAttachment(ContentMail content) throws MessagingException {
		
		MimeMessage message = mailsender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		
		helper.setSubject("My Smiling Face");
		helper.setFrom("franko200ng@gmail.com");
		helper.setTo(content.getReceipient());
		
		helper.setText(content.getContent(), true);
		
		File file = new File("C:\\Users\\User\\Pictures\\Francis-PICS.jpg");
		FileSystemResource filesys = new FileSystemResource(file);
		helper.addAttachment("my-pics.jpg", filesys);
		
		mailsender.send(message);
	}
}
