package com.app.waylearn.Entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.*;



@Entity(name="USER")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
	@Id 
	@GeneratedValue(strategy  = GenerationType.AUTO)
	private  Long id; 
	
	@NotBlank
	private String firstName;
	
	
	private String lastName;
	
	@NotNull
	//@Min(value = 8)
	private String password;
	

	@ManyToOne
	@JoinColumn(name="ID_ROL")
	private Role rol;

	
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


	public User() {
		super();
	}
	
	
	public User(Long id, String firstName, String lastName, @NotNull @Min(8) String password,
			@NotNull @Email(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$") String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
	}


	@NotNull
	@Email(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$")
	private String email;

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
