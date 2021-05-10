package com.app.waylearn.service;

import java.util.List;

import com.app.waylearn.Entities.Topic;

public interface TopicService {
	
	public Topic save(Topic topic); 
	
	public List<Topic> findAll();
	
	public Topic findById(Long id);

}
