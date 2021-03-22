package com.app.waylearn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.waylearn.Entities.Student;
import com.app.waylearn.Repositories.StudentRepository;

@Service
public class StudentServiceImp implements StudentService{

	@Autowired
	private StudentRepository repoStudent;
	
	@Override
	public Student save(Student student) {
		// TODO Auto-generated method stub
		return  repoStudent.save(student);
	}

}
