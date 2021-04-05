package com.app.waylearn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.waylearn.Entities.Role;
import com.app.waylearn.Entities.Student;
import com.app.waylearn.Repositories.StudentRepository;

@Service
public class StudentServiceImp implements StudentService{

	@Autowired
	private StudentRepository repoStudent;
	

	
	@Override
	public Student save(Student student) {
		try {
		
			return  repoStudent.save(student);
		}catch (Exception e) {
			return null;
		}
	}

	@Override
	public void delete(Student student) {
		repoStudent.delete(student);
		
	}

	@Override
	public Student findById(Long id) {
	
		Optional<Student> est =repoStudent.findById(id);
		
		if( !est.isPresent()) {
			return null;
		}
		return est.get();
	}

	@Override
	public List<Student> findAll() {
		return repoStudent.findAll();
	}

}
