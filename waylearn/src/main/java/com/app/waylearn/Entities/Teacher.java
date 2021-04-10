package com.app.waylearn.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import java.util.Set;

import javax.persistence.*;
import javax.persistence.Id;

@Entity(name = "TEACHER")
@PrimaryKeyJoinColumn(name="user_id")
public class Teacher extends User {
	
	@Column(name = "Group_teacher")
	@OneToMany(mappedBy = "teacher",cascade = CascadeType.ALL)
	private Set<Grupo> groups;
	
	
	@Column(name ="CC",nullable = false, unique = true)
	private Long cc;
	
	
	public Teacher() {
		super();
	
	}
	
	public Set<Grupo> getGroups() {
		return groups;
	}


	public void setGroups(Set<Grupo> groups) {
		this.groups = groups;
	}


	public Long getCc() {
		return cc;
	}

	

	public void setCc(Long cc) {
		this.cc = cc;
	}

	

	
}
