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
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.waylearn.WaylearnApplication;

@Service
public class DocumentServiceImp implements DocumentService {



	private final Path rootFolder = Paths.get("src/main/resources/storage");

	@Override
	public void save(MultipartFile file) throws Exception {
		Date fecha = new Date();
		String name = Long.toString(fecha.getTime());
		String fileName = file.getOriginalFilename();
		String ext = "";
		
		int i = fileName.lastIndexOf('.');
		
		ext = fileName.substring(i);
		
		Files.copy(file.getInputStream(), this.rootFolder.resolve(name+ext) );
		
		
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
	public Stream<Path> loadAll(){
		try {
			return Files.walk(this.rootFolder, 1).filter(path->!path.equals(this.rootFolder))
					.map(this.rootFolder::relativize);
			
		}catch (RuntimeException | IOException e) {
			throw new RuntimeException("No se pueden cargar los archivos");
		}
	}
    
}
