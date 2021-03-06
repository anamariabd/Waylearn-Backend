package com.app.waylearn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.app.waylearn.Entities.Student;
import com.app.waylearn.Repositories.StudentRepository;

@SpringBootApplication
public class WaylearnApplication {
	
	@Autowired
	private StudentRepository repositorio;

	
	public static void main(String[] args) {
		SpringApplication.run(WaylearnApplication.class, args);

	}

}
