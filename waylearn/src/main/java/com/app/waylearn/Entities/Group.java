package com.app.waylearn.Entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Group {
 
@Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private Long id;

 @Column(nullable = false)
 private Integer number;
 
 @OneToMany(cascade = CascadeType.ALL,mappedBy = "group"  )
 private Set<Student> ListStudent;
 

 @ManyToOne
 private Teacher teacher;
 
 @OneToMany(mappedBy = "groupe",fetch = FetchType.LAZY)
 private Set<Subject> subjects;
 
 
 public Group(Long id, Integer number, Set<Student> listStudent, Teacher teacher, Set<Subject> subjects) {
		super();
		this.id = id;
		this.number = number;
		ListStudent = listStudent;
		this.teacher = teacher;
		this.subjects = subjects;
	}

public Group() {
	super();
}

public Long getId() {
	return id;
}

public Integer getNumber() {
	return number;
}

public void setNumber(Integer number) {
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

public void setId(Long id) {
	this.id = id;
}




 
 
 
 
 
}
