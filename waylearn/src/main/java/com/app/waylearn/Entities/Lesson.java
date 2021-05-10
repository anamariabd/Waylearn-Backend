package com.app.waylearn.Entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.app.waylearn.Entities.Topic;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Lesson {
 
 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	private String tema;

	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "lessons_id", referencedColumnName = "id")
	private Subject subject;
	
	
	@OneToMany(mappedBy = "lesson_doc", cascade = CascadeType.ALL)
	private Set<Document> document = new HashSet<>();

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "lessons")
	private Topic topic;  
	
	@OneToOne(mappedBy = "lesson_eval",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Evaluation evaluation;
	
	public Lesson() {
		super();
	}


	public Subject getSubject() {
		return subject;
	}


	public Set<Document> getDocument() {
		return document;
	}


	public Topic getTopic() {
		return topic;
	}


	public Evaluation getEvaluation() {
		return evaluation;
	}


	public void setSubject(Subject subject) {
		this.subject = subject;
	}


	public void setDocument(Set<Document> document) {
		this.document = document;
	}


	public void setTopic(Topic topic) {
		this.topic = topic;
	}


	public void setEvaluation(Evaluation evaluation) {
		this.evaluation = evaluation;
	}


	public Lesson(Long id, String tema) {
		super();
		this.id = id;
		this.tema = tema;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTema() {
		return tema;
	}


	public void setTema(String tema) {
		this.tema = tema;
	}
	
}
