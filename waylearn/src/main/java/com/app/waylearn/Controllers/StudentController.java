package com.app.waylearn.Controllers;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {
	
	
	@GetMapping("/estudiante")
	public String accEstudiante(Model model) {
		
		return "estudiantes";
	}
}
