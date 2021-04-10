package com.app.waylearn.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.waylearn.Entities.Grupo;

@Repository
public interface GroupRepository extends JpaRepository<Grupo, Long>{

	
	
}
