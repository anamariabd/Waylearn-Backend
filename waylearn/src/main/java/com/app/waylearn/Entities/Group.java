package com.app.waylearn.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Group {
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private Long id;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public Group(Long id) {
	super();
	this.id = id;
}

public Group() {
	super();
}
 
 
 
 
 
}
