package com.app.waylearn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.waylearn.Entities.Role;
import com.app.waylearn.Repositories.RoleRepository;

@Service
public class RoleServiceImp implements RoleService {

	@Autowired
	private RoleRepository repoRole;
	
	@Override
	public Role save(Role role) {
		return repoRole.save(role);
		
	}

	@Override
	public Role findById(Long id) {
		Optional<Role> rol  = repoRole.findById(id);
		
		if(!rol.isPresent()) {
			return null;
		}
		
		return rol.get();
	}

	@Override
	public List<Role> findAll() {
		return repoRole.findAll();
				
	}
	
	@Override
	public Role findByRol(String rol) {
		return repoRole.findByRol(rol);
	}


}
