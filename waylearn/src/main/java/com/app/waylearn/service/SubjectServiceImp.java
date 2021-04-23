package com.app.waylearn.service;


import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.waylearn.Controllers.GroupController;
import com.app.waylearn.Entities.Subject;
import com.app.waylearn.Repositories.GroupRepository;
import com.app.waylearn.Repositories.SubjectRepository;

@Service
public class SubjectServiceImp implements SubjectService {
	private static Logger log = LoggerFactory.getLogger(SubjectServiceImp.class);

	@Autowired
	private SubjectRepository subjectRepository;
	
	
		
	
	
	@Override
	public Subject save(Subject subject) {
		return subjectRepository.save(subject);
		
	}

	@Override
	public Subject findById(Long id) {
		Optional<Subject> subject = subjectRepository.findById(id);
		if(!subject.isPresent()) {
			return null;
		}
		return subject.get();
	}

	@Override
	public List<Subject> findAll() {
		return subjectRepository.findAll();
	}

	@Override
	public Set<Subject> findByIdTeacher(Long id) {
		
	Set<Subject> list =  subjectRepository.findByIdTeacher(id);
		
		if(list == null) {
			log.info("Esta Vacio");
		}
		log.info(list.toString());
		return  list;
	}

}
