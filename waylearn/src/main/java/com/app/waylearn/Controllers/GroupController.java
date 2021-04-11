package com.app.waylearn.Controllers;

import javax.validation.Valid;

import org.aspectj.bridge.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.app.waylearn.Entities.Grupo;
import com.app.waylearn.Entities.Teacher;
import com.app.waylearn.service.GroupService;
import com.app.waylearn.service.TeacherService;

import payload.MessageResponse;
import payload.RequestGroup;

@RestController
@RequestMapping(path = "/api/group")
public class GroupController {
	private static Logger log = LoggerFactory.getLogger(GroupController.class);
	@Autowired
	private TeacherService teacherservice;
	
	@Autowired
	private GroupService groupServices;
	
	
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@Valid @RequestBody RequestGroup Regroup) throws RuntimeException{
		try {
			log.info("id " + Regroup.getIdTeacher() );
			Long id = Regroup.getIdTeacher();
			Teacher teacher  = teacherservice.findById(id);
			Grupo group = Regroup.getGrupo();
			if (teacher != null) {
				group.setTeacher(teacher);
			}
			
			Grupo grp = groupServices.save(group);
			
			return ResponseEntity.status(HttpStatus.CREATED).body(grp);
			
		}catch (Exception e) {
			throw new  RuntimeException("Error " + e);
			
		}
	}
	
	
	@GetMapping("/{id}")  						
	public ResponseEntity<?> getGrupo(@PathVariable(name = "id") Long id ) {
		
		Grupo grp = groupServices.findById(id);
		
		if(grp == null) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error"));
		}
		
		return ResponseEntity.ok(grp);
	}
	
	@DeleteMapping("/delete/{id}")
 	public  ResponseEntity<?> DeleteGrupo(@PathVariable Long id){
		try {
			Boolean aux = groupServices.delete(id);
			log.info(aux.toString());
			if (aux) {
				return ResponseEntity.ok(new MessageResponse("eliminado"));
			}else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(false);
			}
		}catch (Exception e) {
			 throw new RuntimeException(e);
		}	
	}
	
}
