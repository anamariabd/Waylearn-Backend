package com.app.waylearn.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import com.app.waylearn.Entities.Teacher;
import com.app.waylearn.service.TeacherService;





@CrossOrigin(origins = "http://localhost:8080")
@RestController

@RequestMapping(path="/api/v1/teacher")
public class TeacherControllers {

	@Autowired
	private TeacherService servicesT;
	
	
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
	
	@PostMapping("/registro")
	public Teacher createTeacher(@RequestBody Teacher teacher ){
		
		 return servicesT.save(teacher);
		
	}
	
	
	
}
