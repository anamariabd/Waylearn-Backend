package com.app.waylearn.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.waylearn.Entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
