package com.app.waylearn.Controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.aspectj.bridge.Message;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.waylearn.Entities.Grupo;
import com.app.waylearn.Entities.Subject;
import com.app.waylearn.service.GroupService;
import com.app.waylearn.service.SubjectService;

import payload.MessageResponse;

@RestController
@RequestMapping(path = "/api/v1/subject")
public class SubjectController {
	static final Logger log = org.slf4j.LoggerFactory.getLogger(SubjectController.class);
	@Autowired
	private static SubjectService subjectService;
	

}
