package com.app.waylearn.service;

import java.util.List;

import com.app.waylearn.Entities.Teacher;

public interface TeacherService {

	public Teacher save(Teacher teacher);
	
	public Teacher findById(Long id);
	
	public List<Teacher> findAll();
}
