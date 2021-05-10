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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Evaluation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private String description;
	
	@Column
	private Float overall_score;
	
	@OneToMany(mappedBy = "evaluation", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Question> list_question;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lesson_id")
	private Lesson lesson_eval;
	 
	public Evaluation() {
		super();
	}

	public Evaluation(Long id, String name, String description, Float overall_score) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.overall_score = overall_score;
	}

	
	public Lesson getLesson_eval() {
		return lesson_eval;
	}

	public void setLesson_eval(Lesson lesson_eval) {
		this.lesson_eval = lesson_eval;
	}

	public Set<Question> getList_question() {
		return list_question;
	}

	public void setList_question(Set<Question> list_question) {
		this.list_question = list_question;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Float getOverall_score() {
		return overall_score;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setOverall_score(Float overall_score) {
		this.overall_score = overall_score;
	}
	 
	 
}
