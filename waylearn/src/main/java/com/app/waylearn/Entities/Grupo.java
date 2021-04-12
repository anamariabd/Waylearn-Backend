package com.app.waylearn.Entities;


import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Grupo implements Serializable {
 
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private Long id;

@Column(name="Number_Group")
 private String number;
 
 
 public Grupo() {
		super();
 }
 
 @OneToMany(cascade = CascadeType.ALL,mappedBy = "group" ,fetch = FetchType.LAZY  )
 private Set<Student> ListStudent;
 
 
 @ManyToOne(fetch = FetchType.LAZY)
 @JoinColumn(name = "group_teacher")
 @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})//necesario para evitar error 500
 private Teacher teacher;
 
 @OneToMany(mappedBy = "groupe",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
 private Set<Subject> subjects;
 
 
 public Grupo(Long id, String number, Set<Student> listStudent, Teacher teacher, Set<Subject> subjects) {
		super();
		this.id = id;
		this.number = number;
		ListStudent = listStudent;
		this.teacher = teacher;
		this.subjects = subjects;
	}


 public void setId(Long id) {
		this.id = id;
	}
public Long getId() {
	return id;
}

public String getNumber() {
	return number;
}

public void setNumber(String number) {
	this.number = number;
}

public Set<Student> getListStudent() {
	return ListStudent;
}

public void setListStudent(Set<Student> listStudent) {
	ListStudent = listStudent;
}

public Teacher getTeacher() {
	return teacher;
}

public void setTeacher(Teacher teacher) {
	this.teacher = teacher;
}

public Set<Subject> getSubjects() {
	return subjects;
}

public void setSubjects(Set<Subject> subjects) {
	this.subjects = subjects;
}




 
}
