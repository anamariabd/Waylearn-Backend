package com.app.waylearn.Entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity(name="USER")
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "email") )
@Inheritance(strategy = InheritanceType.JOINED)
public class User implements Serializable{
	@Id 
	@GeneratedValue(strategy  = GenerationType.AUTO)
	private  Long id; 
	
	@NotBlank
	private String firstName;
	
	
	private String lastName;
	
	@Column(name ="CC",nullable = false, unique = true)
	private Long cc;
	
	@NotNull
	//@Min(value = 8)
	private String password;
	

	@ManyToOne
	@JoinColumn(name="ID_ROL")
	private Role rol;

	@NotNull
	@Email(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$")
	private String email;

	public User() {
		super();
	}
	
	
	public User(Long id, String firstName, String lastName, @NotNull @Min(8) String password,
			@NotNull @Email(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$") String email, Long cc) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.cc = cc;
	}

	
	public User(Long id, @NotBlank String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Role getRole() {
		return rol;
	}


	public void setRol(Role rol) {
		this.rol = rol;
	}

	public Long getCc() {
		return cc;
	}


	public void setCc(Long cc) {
		this.cc = cc;
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
		return "User{" +
			"id=" + id +
			", firstName='" + firstName + '\'' +
			", lastName='" + lastName +'\'' +
			'}';
	}

}
