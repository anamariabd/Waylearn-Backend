package com.app.waylearn.Controllers;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.waylearn.service.DocumentService;

import payload.MessageResponse;

@RestController
@RequestMapping(path = "api/upload")
public class DocumentController {

	
	@Autowired
	private DocumentService documentServices;
	
	@PostMapping("/file")
	public ResponseEntity<?> UploadFile(@RequestParam("file") MultipartFile file ) {
		try {
			documentServices.save(file);
			return ResponseEntity.ok(new MessageResponse("The File successfully"));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocurrio un error al cargar el archivo");
		}
	}
	
}
