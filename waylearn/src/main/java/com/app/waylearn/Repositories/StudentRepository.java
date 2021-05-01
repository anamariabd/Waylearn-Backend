package com.app.waylearn.Repositories;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.waylearn.Entities.Student;
import com.app.waylearn.Entities.User;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	@Query("select s from STUDENTS s where s.group.id = :objId")
	List<Student> StudentFindByIdGrupo(@Param("objId") Long id);
	
	//@Query("select s from STUDENTS s where s.email = :objEmail")
	Optional<Student> findByEmail(  String email);
	
	@Query("select s from STUDENTS s where s.group = null")
	List<Student> studentFindByNullGroup();
}
