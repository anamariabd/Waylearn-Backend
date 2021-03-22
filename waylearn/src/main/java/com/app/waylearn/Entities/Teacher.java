package com.app.waylearn.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.*;
import javax.persistence.Id;

@Entity(name = "TEACHER")
@PrimaryKeyJoinColumn(name="user_id")
public class Teacher extends User {
	
	
	
	
	@Column(nullable = false, unique = true)
	private Long cc;
	
	private String Profession;
	
	
	
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
