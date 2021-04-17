package com.app.waylearn.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.app.waylearn.Entities.Grupo;
import com.app.waylearn.Entities.Student;

@Repository
public interface GroupRepository extends JpaRepository<Grupo, Long>{

	
	@Query("select g from Grupo g  where g.teacher.id = :objId")
	List<Grupo> findByIdTeacher(@Param("objId") Long id );
	
	
	
}
