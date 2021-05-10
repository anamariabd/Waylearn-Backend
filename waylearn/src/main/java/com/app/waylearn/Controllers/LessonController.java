package com.app.waylearn.Controllers;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.waylearn.Entities.Lesson;
import com.app.waylearn.Entities.Subject;
import com.app.waylearn.service.LessonService;
import com.app.waylearn.service.SubjectService;

import payload.MessageResponse;

@RestController
@RequestMapping("api/v1/lesson")
public class LessonController {
	private static Logger log = LoggerFactory.getLogger(LessonController.class);

	@Autowired
	private LessonService lessonService;
	
	@Autowired
	private SubjectService subjectService;
	
	@GetMapping("/all")
	public ResponseEntity<?> lessonAll(){
		List<Lesson> lesson = lessonService.findAll();
		return ResponseEntity.ok(lesson);
	}
	//===========================================================================

	
	//=============================================================================
}
