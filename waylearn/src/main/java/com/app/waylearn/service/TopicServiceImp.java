package com.app.waylearn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.waylearn.Entities.Topic;
import com.app.waylearn.Repositories.TopicRepository;


@Service
public class TopicServiceImp implements TopicService {

	@Autowired
	private TopicRepository topicRepository;
	
	@Override
	public Topic save(Topic topic) {
		return topicRepository.save(topic);
	}

	@Override
	public List<Topic> findAll(){
		return topicRepository.findAll(); 
	}
	
	@Override
	public Topic findById(Long id) {
		Optional<Topic> topic = topicRepository.findById(id);
		if(!topic.isPresent()) {
			 return null;
		}
			return topic.get();	
		
	}
}
