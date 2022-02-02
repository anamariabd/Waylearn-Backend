package com.app.waylearn.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import java.util.Set;

import javax.persistence.*;
import javax.persistence.Id;

@Entity(name = "TEACHER")
@PrimaryKeyJoinColumn(name="user_id")
public class Teacher extends User {
	
	
	@OneToMany(mappedBy = "teacher",cascade = CascadeType.ALL)
	private Set<Group> groups;
	
	
	@Column(nullable = false, unique = true)
	private Long cc;
	
	private String Profession;
	
	
	
	public Set<Group> getGroups() {
		return groups;
	}


	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}


	public Teacher() {
		super();
	
	}


	public Long getCc() {
		return cc;
	}

	

	public void setCc(Long cc) {
		this.cc = cc;
	}

	

	public String getProfession() {
		return Profession;
	}

	public void setProfession(String profession) {
		Profession = profession;
	}
	
}
