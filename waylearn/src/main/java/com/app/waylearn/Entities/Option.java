package com.app.waylearn.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Option {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String choice;
	
	private Float state;

	@ManyToOne()
	@JoinColumn(name = "option_question")
	private Question optionQuestion; 
	
	public Option() {
		super();
	}
	
	public Option(Long id, String choice, Float state) {
		super();
		this.id = id;
		this.choice = choice;
		this.state = state;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}

	public Float getState() {
		return state;
	}

	public void setState(Float state) {
		this.state = state;
	}
	
	
	
}
