package com.app.waylearn.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.app.waylearn.Entities.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
