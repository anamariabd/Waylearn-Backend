package com.app.waylearn.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.waylearn.Entities.Role;

@Repository
public interface RoleRepository  extends JpaRepository<Role, Long>{
	
	Role findByRol(String rol);
}
