package com.app.waylearn.Entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Subject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	private String name;


	public Subject() {
		super();
	}

	@OneToMany(mappedBy = "subject", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Lesson> lessons;
	
	@ManyToOne
	private Group groupe;
	
	public Subject(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}


	public Group getGroupe() {
		return groupe;
	}


	public void setGroupe(Group group) {
		this.groupe = group;
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
	};
	

}
