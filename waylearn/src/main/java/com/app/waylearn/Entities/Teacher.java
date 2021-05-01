package com.app.waylearn.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.annotation.ObjectIdResolver;

@Entity(name = "TEACHER")
@PrimaryKeyJoinColumn(name="user_id")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Teacher extends User  {
	
	@Column(name = "Group_teacher")
	@OneToMany(mappedBy = "teacher",cascade = CascadeType.ALL)
	private Set<Grupo> groups;
	
	
	public Teacher() {
		super();
	
	}
	
	public Set<Grupo> getGroups() {
		return groups;
	}


	public void setGroups(Set<Grupo> groups) {
		this.groups = groups;
	}


	

	
}
