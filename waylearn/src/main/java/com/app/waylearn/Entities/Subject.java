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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Subject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;

	@OneToMany(mappedBy = "subject", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Lesson> lessons = new HashSet<>();
	
	@ManyToMany(mappedBy = "list_subject",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Set<Grupo> groupe = new HashSet<>();

	public Subject() {
		super();
	}

	public Subject(String name) {
		super();
		this.name = name;
	}
	public Set<Lesson> getLessons() {
		return lessons;
	}

	public void setLessons(Set<Lesson> lessons) {
		this.lessons = lessons;
	}
	
	
	public void setLessones(Lesson lesson) {
		this.lessons.add(lesson);
	}


	public Subject(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Set<Grupo> getGroupe() {
		return groupe;
	}


	public void setGroupe(Grupo groupe) {
		this.groupe.add(groupe);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	

}
