package com.app.waylearn.Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.waylearn.Entities.Grupo;
import com.app.waylearn.Entities.Student;
import com.app.waylearn.Entities.Teacher;
import com.app.waylearn.service.GroupService;
import com.app.waylearn.service.StudentService;
import com.app.waylearn.service.TeacherService;
import payload.MessageResponse;
import payload.RequestGroup;

@RestController
@RequestMapping(path = "/api/v1/group")
public class GroupController {
	private static Logger log = LoggerFactory.getLogger(GroupController.class);
	@Autowired
	private TeacherService teacherservice;
	

	@Autowired
	private GroupService groupServices;
	
	@Autowired 
	private StudentService studentService;
	
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
			if(groupServices.findById(id)  != null) {
				 groupServices.delete(id);
				 
				 if(groupServices.findById(id)  == null) {
					 return ResponseEntity.ok(new MessageResponse("eliminado"));
				}
			}return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(false);
		}catch (Exception e) {
			 throw new RuntimeException(e);
		}	
	}
	
	
	@PutMapping("/addStudent/{id}")
	public ResponseEntity<?> AddStudetGrupo(@PathVariable(name =  "id") Long id, @RequestBody Map<String,Long>  idStudent){
		Long studentId = idStudent.get("student");
		log.info("llegando a agregar studiante "+studentId + " " + id );
		
		 Grupo grp  = groupServices.findById(id);
		 Student student = studentService.findById(studentId);
		 if(grp != null &&  student != null ) {
			//grp.getListStudent().add(student); 
			if (grp.getListStudent().size() < grp.getAmount()) {
				 student.setGroup(grp);
					studentService.save(student);
					Grupo	grp1 = groupServices.findById(id);
					return ResponseEntity.ok(grp1);
			}
			
		 }
		 return ResponseEntity.status(HttpStatus.FAILED_DEPENDENCY).body(new MessageResponse("Error no se pudo agregar"));
		
	}
	
	
	@GetMapping("/teacher/{id}")
	public ResponseEntity<List<Grupo>> findByTeacherId(@PathVariable(name ="id") Long id){
		
		List<Grupo> list = groupServices.findByTeacher(id);
		List<Grupo> grp = new ArrayList<>();
		for(Grupo g : list) {
			grp.add(new Grupo(g.getId(),g.getNumber(),g.getAmount()));
		}
		return ResponseEntity.ok(grp);
		
	}
	
	@GetMapping("/student/{id}")
	public ResponseEntity<?> ListStudents(@PathVariable(name = "id") Long id){
		
		List<Student> list = studentService.FindByIdGroup(id);
		return ResponseEntity.ok(list);
	}
 }
