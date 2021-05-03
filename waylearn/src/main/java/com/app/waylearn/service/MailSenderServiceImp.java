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
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class MailSenderServiceImp  {

	
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Value("${spring.mail.username}")
	private String from;
	
	@Async
	public void mailSend(String to, String subject, String content ) {
		
		SimpleMailMessage email = new SimpleMailMessage();
		
		
		email.setFrom(from);
		email.setTo(to);
		email.setSubject(subject);
		email.setText(content);
		
		mailSender.send(email);
		
	}
	@Async
	public void mailRegister(String to, String subject, String email,String name) throws MessagingException {
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
					+ "<meta charset=\"UTF-8\">"
					+"<style>"
					+ 		"p { line-height:1.5; text-align: justify;}"
					+ 		"div { width:90%; }"
					+ "</style>"
					+ "</head>"
					+ "<body>"
					+ "<div>"
					+ "<img alt='Logo' src='src/main/resources/static/img/logo.png'>"
					+ "<br>"
					+ "  <p>Estimado(a), <strong>"+ name +"</strong>:</p>"
					+"<br>"
					+ "<p>Oficialmente haces parte de la familia WayLearn . Queremos compartirte indicaciones generales y notificarte la culminacion de la activación de tu cuenta.</p>"
					+ "<p><strong>USUARIO</strong>:</p>"
					+ "<p>El usuario para acceder a los servicios de WayLearn y tu correo electrónico registrado es: <b>"+email+"</b></p><br>"
					+ "<p><strong>PLATAFORMA DE APRENDIZAJE</strong>:</p>"
					+ "<p>La plataforma ya se encuentra activa para ingreso, en nuestra seccion de instrucciones se encuentran las indicaciones necesarias para acceder a los cursos.</p>"
				    + "<p>Te recomendamos seguirnos por nuestras redes sociales donde encontrarás información de interés.</p>"
					+ "<p>¡Bienvenido a esta experiencia de aprendizaje!</p>"
					+ "	<p>	<i>Este mensaje es generado de forma automática por una aplicación, en caso de contestarlo no será respondido.</i></p>"
					+ " </div>"
					+ "</body>"
					+ "</html>", true);
			 //helper.addAttachment("myLogo", file);
			mailSender.send(mimeMessage);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	
	
	
	
}
