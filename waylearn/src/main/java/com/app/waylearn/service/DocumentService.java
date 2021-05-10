package com.app.waylearn.service;

import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.app.waylearn.Entities.Document;

public interface DocumentService {
	
	public boolean save(MultipartFile file) throws Exception;
	
	public Resource  load (String name) throws Exception;
	
	public Stream<Path> loadAll() throws Exception;
	
	public Document data(String name);
	
	public boolean exist(String name); 
		
	
	
}
