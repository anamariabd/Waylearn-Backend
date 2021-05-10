package com.app.waylearn.Controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.aspectj.bridge.Message;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.waylearn.Entities.Grupo;
import com.app.waylearn.Entities.Lesson;
import com.app.waylearn.Entities.Subject;
import com.app.waylearn.Entities.Topic;
import com.app.waylearn.Repositories.TopicRepository;
import com.app.waylearn.service.GroupService;
import com.app.waylearn.service.LessonService;
import com.app.waylearn.service.SubjectService;
import com.app.waylearn.service.TopicService;

import payload.MessageResponse;

@RestController
@RequestMapping(path = "/api/v1/subject")
public class SubjectController {
	static final Logger log = org.slf4j.LoggerFactory.getLogger(SubjectController.class);
	@Autowired
	private  SubjectService subjectService;
	
	@Autowired
	private TopicService topicService;
	
	@Autowired
	private LessonService lessonService;
	
	@GetMapping("/gets")
	public ResponseEntity<?> getAll() {
		List<Subject> subjects_list  = subjectService.findAll();
		return !subjects_list.isEmpty() ? ResponseEntity.ok(subjects_list): ResponseEntity.badRequest().body(new MessageResponse("No se encontraron resultados"));
		
		
	}
	
	@PutMapping("/addLesson/{id}")
	public ResponseEntity<?> create(@Valid @RequestBody Lesson Objlesson, @PathVariable(name="id") Long idSubject){
		try {
			log.info("data "+ Objlesson.getTema()+ " Subtema "+ Objlesson.getTopic().getName() );
			Topic topic;
			Subject subject  = subjectService.findById(idSubject);
			if (Objlesson.getTopic().getName()!= null) {
				topic = topicService.save(Objlesson.getTopic());
				Objlesson.setTopic(topic);
				Objlesson.setSubject(subject);
			}
			Lesson lesson = lessonService.save(Objlesson);
			if(lesson != null) {
				return ResponseEntity.ok(lesson);
			}
			return ResponseEntity.badRequest().body(new MessageResponse("No se logró guardar"));
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
}
