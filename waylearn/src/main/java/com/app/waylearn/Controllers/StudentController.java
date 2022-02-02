package com.app.waylearn.Controllers;

import java.util.LinkedList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.waylearn.Entities.Role;
import com.app.waylearn.Entities.Student;
import com.app.waylearn.service.RoleService;
import com.app.waylearn.service.StudentService;
import com.app.waylearn.service.UserService;

import payload.MessageResponse;

@CrossOrigin(origins = "http://localhost:3000")

@RestController

@RequestMapping(path = "/api/v1/student")
public class StudentController {
	
	@Autowired
	private StudentService serviceStudent;
	
	@Autowired
	private UserService userServices;
	
	@Autowired
	private RoleService repoRol;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@GetMapping("/{id}")
	public Student getStudent(@PathVariable Long id) {
		try {
			return serviceStudent.findById(id);
		}catch (Exception e) {
			return null;
		}
	}
	
	@GetMapping("/gets")
	public List<Student> getAllStudent(){
		return serviceStudent.findAll();
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> createStudent(@Valid @RequestBody Student student) {
		
		if (userServices.existsByEmail(student.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}
		Role rol = repoRol.findByRol("student");
		if(rol == null) {
			
				new RuntimeException("Error: Role is not found.");
			
		}
		student.setRol(rol);
		String aux = bCryptPasswordEncoder.encode(student.getPassword());
		student.setPassword(aux);
		serviceStudent.save(student);
		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
		
	}
}
