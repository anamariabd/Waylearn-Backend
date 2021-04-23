package com.app.waylearn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.waylearn.Entities.Lesson;
import com.app.waylearn.Repositories.LessonRepository;

@Service
public class LessonServiceImp implements LessonService{

	@Autowired
	private LessonRepository lessonRespository; 
	
	@Override
	public Lesson save (Lesson lesson) {
		return lessonRespository.save(lesson);
	}

	@Override
	public Lesson findById (Long id) {
		Optional<Lesson> lesson = lessonRespository.findById(id);
		if (!lesson.isPresent()) {
			return null;
		}
		return lesson.get();
	}

	@Override
	public List<Lesson> findAll () {
		return lessonRespository.findAll();
	}

}
