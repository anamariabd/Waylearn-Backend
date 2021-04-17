package com.app.waylearn.Entities;


import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity(name="STUDENTS")
@PrimaryKeyJoinColumn(name="user_id")

public class Student extends User{
	
	private String semestre;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "Student_Group")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Grupo group;
	
	public Student() {
		super();
	}
	
	public Student(Long id, String firstName, String lastName) {
		super(id,firstName,lastName);
	}
	
	public Grupo getGroup() {
		return group;
	}



	public void setGroup(Grupo group) {
		this.group = group;
	}



	public String getSemestre() {
		return semestre;
	}

	
	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}


}
