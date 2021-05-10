package com.app.waylearn.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String response;

	private String state;
	
	@ManyToOne
	@JoinColumn(name ="answer_question")
	private Question questions;
	
	
	public Answer(Long id, String response, String state) {
		super();
		this.id = id;
		this.response = response;
		this.state = state;
	}
	
	public Answer() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	
	
	
	
}
