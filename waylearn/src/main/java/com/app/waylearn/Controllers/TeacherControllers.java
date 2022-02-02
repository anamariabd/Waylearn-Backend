package com.app.waylearn.Controllers;


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
import java.util.List;


import com.app.waylearn.Entities.Role;
import com.app.waylearn.Entities.Teacher;
import com.app.waylearn.service.RoleService;
import com.app.waylearn.service.TeacherService;
import com.app.waylearn.service.UserService;

import payload.MessageResponse;





@CrossOrigin(origins = "http://localhost:3000")
@RestController

@RequestMapping(path="/api/v1/teacher")
public class TeacherControllers {

	
	@Autowired
	private TeacherService servicesT;
	
	
	@Autowired
	private UserService userServices;
	
	@Autowired
	private RoleService repoRol;
	
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@GetMapping("/{id}")
	public Teacher getTeacher(@PathVariable Long id) {
		try {
			 return servicesT.findById(id);
		}catch (Exception e) {
			return null;
		}
		
		
	}
	
	@GetMapping("/gets")
	public List<Teacher> getAllTeacher(){
		return servicesT.findAll();
		
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> createTeacher(@RequestBody Teacher teacher ){ //Empaqueta en un solo objeto todos los atributos de los campos en la vista registro.
		if (userServices.existsByEmail(teacher.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}
		
		Role rol = repoRol.findByRol("teacher");
		if(rol == null) {
			
			new RuntimeException("Error: Role is not found.");
		
		}
		teacher.setRol(rol);
		String passwordEncoder = bCryptPasswordEncoder.encode(teacher.getPassword());
		
		teacher.setPassword(passwordEncoder);
		servicesT.save(teacher);
		
		 return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
		
	}
	
	
	
}
