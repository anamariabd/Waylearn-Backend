package com.app.waylearn.service;

import java.io.File;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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
	
	public void mailRegister(String to, String subject, String content) throws MessagingException {
		try {
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
			helper.setFrom(from);
			helper.setTo(to);
			helper.setSubject(subject);
			//helper.setText("my text <img src='cid:myLogo'>", true);
		    FileSystemResource file = new FileSystemResource(new File("src/main/resources/static/img/log.jpg"));
			//helper.addInline("myLogo", new ClassPathResource("src/main/resources/static/img/log.jpg"));
		   
			helper.setText("<!DOCTYPE html>\r\n"
					+ "<html>"
					+ "<head>"
					+ 	"<meta charset=\"UTF-8\">"
					+ "</head>"
					
					+ "<body>"
					+ "  <div><img alt='Logo' src='src/main/resources/static/img/log.jpg'>"
					+ "<br>"
						
					+ "  <p> Apreciado usuario <strong>"+ content +"</strong> su registro ha sido exitoso, gracias por registrarse a Waylearn</p>"
					+ "  </div>"
					+ "</body>"
					+ "</html>", true);
			 //helper.addAttachment("myLogo", file);
			mailSender.send(mimeMessage);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	
	
	
	
}
