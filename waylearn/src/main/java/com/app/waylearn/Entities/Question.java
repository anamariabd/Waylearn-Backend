package com.app.waylearn.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String Namequestion;
	private String contenido;
	private String score;
	
	public Question() {
		super();
	}
	
	
	
	public Question(Long id, String namequestion, String contenido, String score) {
		super();
		this.id = id;
		Namequestion = namequestion;
		this.contenido = contenido;
		this.score = score;
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNamequestion() {
		return Namequestion;
	}
	public void setNamequestion(String namequestion) {
		Namequestion = namequestion;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	
	
	
}
