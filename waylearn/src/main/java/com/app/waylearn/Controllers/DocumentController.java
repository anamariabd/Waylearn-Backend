package com.app.waylearn.Controllers;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.http.HttpHeaders;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.hateoas.config.MediaTypeConfigurationProvider;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.app.waylearn.Entities.Document;
import com.app.waylearn.service.DocumentService;

import jdk.jfr.ContentType;
import payload.FileData;
import payload.MessageResponse;

@RestController
@RequestMapping(path = "api/v1/upload")
public class DocumentController {
	
	static final Logger log = LoggerFactory.getLogger(DocumentController.class);
	
	@Autowired
	private DocumentService documentServices;
	
	@PostMapping("/file")
	public ResponseEntity<?> UploadFile(@RequestParam("file") MultipartFile file ) {
		try {
			boolean request= documentServices.save(file);
			return request ?ResponseEntity.ok(new MessageResponse("The File successfully")):ResponseEntity.status(HttpStatus.CONFLICT).body(new MessageResponse("Ya existe un documento con ese nombre")) ;
		} catch (Exception e) {
		
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocurrio un error al cargar el archivo");
		}
	}

	@GetMapping("/files/{filename}")
     public ResponseEntity<?> getFile(@PathVariable(required = true) String filename){
	  try {
		  Document document  = documentServices.data(filename);
	
		  if(document != null) {
			  
			  Resource file = documentServices.load(document.getHash()+document.getExt());
			  //InputStream in = new FileInputStream(file.getFile());
			 /* String fileName = file.getFilename();
			  String ext = "";
			  int i = fileName.lastIndexOf('.');
			  ext = fileName.substring(++i);*/
		//	  MediaType extension = MediaType.valueOf(document.getMimeType());
			  
		        return ResponseEntity.ok()
		        		.contentLength(file.contentLength())
		        		.contentType(MediaType.valueOf(document.getMimeType())) // Tipo de contenido a retornar.
		        		.body( new InputStreamResource(file.getInputStream()));
		        
		  }
		//  throw new RuntimeException();
		  return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(new MessageResponse("no se encontró el archivo especificado: " + filename));
		  	        		
	        		/*
	        		  	header(org.springframework.http.HttpHeaders.CONTENT_DISPOSITION,
	                	"attachment; filename=\""+file.getFilename() + "\"").body(file); 
	                */
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
