package com.app.waylearn;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.app.waylearn.Entities.Role;
import com.app.waylearn.service.DocumentService;
import com.app.waylearn.service.RoleService;


@SpringBootApplication
public class WaylearnApplication {
 
	
	@Autowired
	public RoleService roleService;
	
	final static Logger log = LoggerFactory.getLogger(WaylearnApplication.class);
	
	public static void init() {
		File storage =  new File("src/main/resources/storage");
		if(!storage.exists()) {
			if(!storage.mkdirs()) {
				log.error("error al crear el directorio");
			}
		}
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(WaylearnApplication.class, args);
		init();
		
		
		// final Path rootFolder = Paths.get("uploads");
		// log.info();
	}

	@PostConstruct
	public void addRole() {
		Role rr = roleService.findByRol("teacher");
		if(rr == null) {
			log.info("Creando Roles");
			roleService.save(new Role("teacher"));
			roleService.save(new Role("student"));
		}else {
			log.info("Roles Ya existen");
		}
		
		
		
		
	}
	
}
