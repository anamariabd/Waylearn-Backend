package com.app.waylearn.service;

import java.util.List;
import java.util.Set;

import com.app.waylearn.Entities.Subject;

public interface SubjectService {
	
	public Subject save (Subject subject);
	
	public Subject findById(Long id);
	
	public List<Subject> findAll();
	
	public Set<Subject> findByIdTeacher(Long id);
}
