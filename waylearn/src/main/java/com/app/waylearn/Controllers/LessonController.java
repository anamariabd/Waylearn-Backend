package com.app.waylearn.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.waylearn.Entities.Lesson;
import com.app.waylearn.service.LessonService;

@RestController
@RequestMapping("api/v1/lesson")
public class LessonController {
	
	@Autowired
	private LessonService lessonService;
	
	
	
	@GetMapping("/all")
	public ResponseEntity<?> lessonAll(){
		List<Lesson> lesson = lessonService.findAll();
		return ResponseEntity.ok(lesson);
		
	}
	
}
