package com.app.waylearn.service;

import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface DocumentService {
	
	public void save(MultipartFile file) throws Exception;
	
	public Resource  load (String name) throws Exception;
	
	public Stream<Path> loadAll() throws Exception;
	
	
}
