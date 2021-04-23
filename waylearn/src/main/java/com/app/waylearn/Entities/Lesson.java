package com.app.waylearn.Entities;

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


@Entity
public class Lesson {
 
 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	private String tema;

	
	@ManyToOne
	@JoinColumn(name = "lessons_id")
	private Subject subject;
	
	
	@OneToMany(mappedBy = "lesson", cascade =CascadeType.ALL)
	private Set<Document> document;

	public Lesson() {
		super();
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
