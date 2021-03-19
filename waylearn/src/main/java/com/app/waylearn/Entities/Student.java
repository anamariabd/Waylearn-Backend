package com.app.waylearn.Entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Student")
public class Student {
	private @Id @GeneratedValue Long id; 
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;

	private Student() {}

	public Student(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public int hashCode() {

		return Objects.hash(id, firstName, lastName);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Estudiante{" +
			"id=" + id +
			", firstName='" + firstName + '\'' +
			", lastName='" + lastName +'\'' +
			'}';
	}
}
