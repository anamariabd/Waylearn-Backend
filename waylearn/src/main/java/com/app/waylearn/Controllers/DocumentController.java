package com.app.waylearn.Controllers;

import java.net.http.HttpHeaders;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.app.waylearn.service.DocumentService;

import payload.FileData;
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

	@GetMapping("/files/{filename:.+}")
     public ResponseEntity<?> getFile(@PathVariable String filename){
	  try {
		  Resource file = documentServices.load(filename);
	        return ResponseEntity.ok().header(org.springframework.http.HttpHeaders.CONTENT_DISPOSITION,
	                "attachment; filename=\""+file.getFilename() + "\"").body(file);
	  }catch (Exception e) {
		throw new RuntimeException("Error :" + e.getMessage());
	}
			
	  }


	@GetMapping("/fileAll")
	public ResponseEntity<?> getFiles(){
		List<FileData> fileInfo;
		try {
			fileInfo = documentServices.loadAll().map(path ->{
				
				String filename = path.getFileName().toString();
				String url = MvcUriComponentsBuilder.fromMethodName(DocumentController.class
						,"getFile",path.getFileName().toString()).build().toString();
					return new FileData(url, filename);
			}).collect(Collectors.toList());
			return ResponseEntity.status(HttpStatus.OK).body(fileInfo);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error al buscar datos");
		}
		
		
		
	}
	
	
	
}
