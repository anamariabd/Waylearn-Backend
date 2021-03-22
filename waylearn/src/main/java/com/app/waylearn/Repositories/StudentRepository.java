package com.app.waylearn.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.waylearn.Entities.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

}
