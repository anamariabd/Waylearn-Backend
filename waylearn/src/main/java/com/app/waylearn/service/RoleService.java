package com.app.waylearn.service;

import java.util.List;

import com.app.waylearn.Entities.Role;

public interface RoleService {
	
	public Role save(Role role);
	
	public Role findById(Long id);
	
	public List<Role> findAll();
	
	
	public Role findByRol(String rol);
}
