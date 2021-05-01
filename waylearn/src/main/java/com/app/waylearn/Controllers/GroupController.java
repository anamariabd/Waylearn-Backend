package com.app.waylearn.Controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;

import org.aspectj.bridge.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.app.waylearn.Entities.Subject;
import com.app.waylearn.Entities.Teacher;
import com.app.waylearn.service.GroupService;
import com.app.waylearn.service.StudentService;
import com.app.waylearn.service.SubjectService;
import com.app.waylearn.service.TeacherService;
import payload.MessageResponse;
import payload.RequestGroup;
import com.app.waylearn.Controllers.SubjectController;

@CrossOrigin(origins = "http://localhost:3000")
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

	@Autowired
	private SubjectService subjectService;
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@Valid @RequestBody RequestGroup Regroup) throws RuntimeException{
		try {
			log.info("id " + Regroup.getIdTeacher() );
			
			Long id = Regroup.getIdTeacher();
			Teacher teacher  = teacherservice.findById(id);
			Grupo group = Regroup.getGrupo();
			
			if (teacher != null) {
				group.setTeacher(teacher);
				Set<Subject> subjects  = CreateSubject(teacher.getId());
				group.setSubjects(subjects);
				Grupo grp = groupServices.save(group);
				return ResponseEntity.status(HttpStatus.CREATED).body(grp);
			}else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessageResponse("No se encontró el docente"));
			}
			
			
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
 

	@GetMapping("/subject/{id}")
	public ResponseEntity<?> subjectForTeacher(@PathVariable Long id){
		
		Set<Subject> list = subjectService.findByIdTeacher(id);
		
		if(list.isEmpty()) {
			return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(new  MessageResponse("no encontrado"));
		}
		return ResponseEntity.ok(list);
	}
	
	
	public  Set<Subject> CreateSubject(Long idTeacher) {  
		try {
			
			Set<Subject> list = subjectService.findByIdTeacher(idTeacher);
			if (!list.isEmpty()) {
				return  list;
			}
			Set<Subject> list_subject = new HashSet<>();
			
			list_subject.add(subjectService.save(new Subject("SOCIALES")));
			list_subject.add(subjectService.save(new Subject("ARTISTICA")));
			list_subject.add(subjectService.save(new Subject("ESPAÑOL")));
			list_subject.add(subjectService.save(new Subject("MATEMÁTICAS")));
			list_subject.add(subjectService.save(new Subject("ETICA")));
			list_subject.add(subjectService.save(new Subject("INGLES")));
			list_subject.add(subjectService.save(new Subject("NATURALES")));
			list_subject.add(subjectService.save(new Subject("INFORMATICA")));
			
			return list_subject;
		}catch (Exception e) {
			throw new RuntimeException("error: " + e );
		}
	}

}
