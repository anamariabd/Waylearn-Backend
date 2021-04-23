package com.app.waylearn.Repositories;


import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.waylearn.Entities.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

	@Query("select s from Subject s join s.groupe g where g.teacher.id = :objId")
	Set<Subject> findByIdTeacher(@Param("objId") Long idtacher);
}
