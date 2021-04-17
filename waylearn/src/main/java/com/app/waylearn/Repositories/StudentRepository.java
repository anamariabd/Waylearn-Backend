package com.app.waylearn.Repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.waylearn.Entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	@Query("select s from STUDENTS s where s.group.id = :objId")
	List<Student> StudentFindByIdGrupo(@Param("objId") Long id);
}
