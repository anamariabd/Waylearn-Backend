package com.app.waylearn;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.waylearn.Entities.Role;
import com.app.waylearn.Entities.Teacher;
import com.app.waylearn.Repositories.RoleRepository;
import com.app.waylearn.Repositories.StudentRepository;
import com.app.waylearn.Repositories.TeacherRepository;



@SpringBootTest
class WaylearnApplicationTests {

	@Autowired
	private TeacherRepository teacherRepo;
	
	@Autowired
	private RoleRepository rols;
	
	@Autowired
	private StudentRepository studedtRepo;
	
	@Test
	public void creaUserTest() {
		Role rol = new Role();
		rol.setRol("teacher");
		rols.save(rol);
		Teacher userT = new Teacher();
		userT.setCc(10545441L);
		userT.setEmail("anana@gmail.com");
		userT.setFirstName("ana");
		userT.setLastName("Buenahora");
		userT.setPassword("123");
		userT.setRol(rol);
		Teacher aux = teacherRepo.save(userT);
		
		assertTrue(aux.getPassword().equalsIgnoreCase(userT.getPassword()));
	
		
		
	}

}
