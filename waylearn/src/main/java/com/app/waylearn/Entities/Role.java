package com.app.waylearn.Entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "ROLES")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	private String rol;
	
	@OneToMany(mappedBy = "rol",cascade = CascadeType.ALL )
	private List<User> users;
	
	public Role() {
		super();
	}

	public Role( @NotNull String rol) {
		super();
	
		this.rol = rol;
	}
	
	public Role(Long id, @NotNull String rol) {
		super();
		this.id = id;
		this.rol = rol;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}



	


}
