package com.app.waylearn.Entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String Namequestion;
	
	@Column	
	private String contenido;
	
	@Column
	private String score;
	
	@OneToMany(mappedBy = "questions", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Set<Answer> answers;
	
	@OneToMany(mappedBy = "optionQuestion", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Option> options;
	
	@ManyToOne()
	@JoinColumn(name = "question_evaluations")
	private Evaluation evaluation; 
	
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



	public Set<Answer> getAnswers() {
		return answers;
	}



	public Set<Option> getOptions() {
		return options;
	}



	public Evaluation getEvaluation() {
		return evaluation;
	}



	public void setAnswers(Set<Answer> answers) {
		this.answers = answers;
	}



	public void setOptions(Set<Option> options) {
		this.options = options;
	}



	public void setEvaluation(Evaluation evaluation) {
		this.evaluation = evaluation;
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
