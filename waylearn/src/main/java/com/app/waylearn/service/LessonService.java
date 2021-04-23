package com.app.waylearn.service;

import java.util.List;

import com.app.waylearn.Entities.Lesson;

public interface LessonService {
	
	public Lesson save ( Lesson lesson );
	
	public Lesson findById ( Long id );
	
	public List<Lesson> findAll();
}
