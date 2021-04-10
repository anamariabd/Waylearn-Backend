package com.app.waylearn.Entities;


import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity(name="STUDENTS")
@PrimaryKeyJoinColumn(name="user_id")
public class Student extends User{
	
	private String semestre;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Student_Group")
	private Grupo group;
	
	public Student() {
		super();
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
