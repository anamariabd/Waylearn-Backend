package com.app.waylearn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.waylearn.Entities.Role;
import com.app.waylearn.Entities.Teacher;
import com.app.waylearn.Repositories.TeacherRepository;

@Service
public class TeacherServiceImp implements TeacherService{

	@Autowired
	private TeacherRepository repoTeacher;
	

	
	@Override
	public Teacher save(Teacher teacher) {
		return repoTeacher.save(teacher);
	}

	@Override
	public Teacher findById(Long id) {
		Optional<Teacher> us = repoTeacher.findById(id);
		if(!us.isPresent()) {
			return null;
		}
		return us.get();
	
	}

	@Override
	public List<Teacher> findAll() {
		 return repoTeacher.findAll();
		
	}

}
