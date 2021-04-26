package com.app.waylearn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSenderServiceImp  {

	
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Value("${spring.mail.username}")
	private String from;
	
	public void mailSend(String to, String subject, String content ) {
		
		SimpleMailMessage email = new SimpleMailMessage();
		
		email.setFrom(from);
		email.setTo(to);
		email.setSubject(subject);
		email.setText(content);
		
		mailSender.send(email);
		
	}

	
	
	
	
}
