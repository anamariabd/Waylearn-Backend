package com.app.waylearn.service;

import java.util.List;

import com.app.waylearn.Entities.Student;

public interface StudentService {
	
	public Student save(Student student);
	
	public void delete(Student student);
	
	public Student findById(Long id);
	
	public Student findByEmail(String email); 
	
	public List<Student> findAll();
	
	public List<Student> FindByIdGroup(Long id);
	
	public List<Student> FindByIdNullGroup();
}
