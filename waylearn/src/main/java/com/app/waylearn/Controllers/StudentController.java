package com.app.waylearn.Controllers;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.waylearn.Entities.Student;
import com.app.waylearn.service.StudentService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(path = "/api/v1/student")
public class StudentController {
	
	@Autowired
	private StudentService serviceStudent;
	
	@GetMapping("/{id}")
	public Student getStudent(@PathVariable Long id) {
		return serviceStudent.findById(id);
	}
	
	@GetMapping("/gets")
	public List<Student> getAllStudent(){
		return serviceStudent.findAll();
	}
	
	@PostMapping("/registro")
	public Student createStudent(@RequestBody Student student) {
		return serviceStudent.save(student);
		
	}
}
