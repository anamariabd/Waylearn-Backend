package com.app.waylearn.service;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Stream;

import javax.management.RuntimeErrorException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.waylearn.WaylearnApplication;
import com.app.waylearn.Controllers.SubjectController;
import com.app.waylearn.Entities.Document;
import com.app.waylearn.Repositories.DocumentRepository;

@Service
public class DocumentServiceImp implements DocumentService {

	static final Logger log = org.slf4j.LoggerFactory.getLogger(DocumentServiceImp.class);
	@Autowired
	private DocumentRepository documentRepository;
	
	private final Path rootFolder = Paths.get("src/main/resources/storage");

	@Override
	public boolean save(MultipartFile file) throws Exception {
		try {
		Document document = new Document();
		String fileName = file.getOriginalFilename();
		int i = fileName.lastIndexOf('.');
		document.setName(fileName.substring(0, i));
		if (exist(document.getName())){
			log.info("ya existe");
			return false;
		}
		Date fecha = new Date();
		document.setHash(Long.toString(fecha.getTime()));
		document.setMimeType(file.getContentType());
		document.setExt(fileName.substring(i));
		
		
		log.info(" Hash: "+document.getHash() +" Extension: "+ document.getExt() +" Nombre del archivo: " + document.getName()+" MimeType: "+ document.getMimeType() );
		Document doc = documentRepository.save(document);
		Files.copy(file.getInputStream(), this.rootFolder.resolve(doc.getHash()+doc.getExt()));
		return true;
		}catch (Exception e) {
			throw new RuntimeException(e.getCause());
		}
		
	}

	@Override
	public Resource load(String name) throws Exception {
		try {
			Path file = rootFolder.resolve(name);
			Resource resource = new UrlResource(file.toUri());
			if(resource.exists() || resource.isReadable()) {
				return resource;
			}else {
				throw new RuntimeException("No se puede leer el archivo");
			}
			
		}catch (Exception e) {
			throw new Exception("Error: " + e.getMessage());
		}
	}
	
	@Override
	public boolean exist(String name) {
		try {
			Boolean doc =  documentRepository.existByName(name);
			if(doc == null || doc.booleanValue() == false ) {
				return false;
			}
			return true;
		}catch(Exception e) {
			throw new RuntimeException(e.getCause());
		}
		
	}
	
	@Override
	public Stream<Path> loadAll(){
		try {
			return Files.walk(this.rootFolder, 1).filter(path->!path.equals(this.rootFolder))
					.map(this.rootFolder::relativize);
			
		}catch (RuntimeException | IOException e) {
			throw new RuntimeException("No se pueden cargar los archivos");
		}
	}

	@Override
	public Document data(String name) {
		try {
			Document document =  documentRepository.findByName(name);
			return document != null ? document: null;
			
		}catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		
	}
    
}
