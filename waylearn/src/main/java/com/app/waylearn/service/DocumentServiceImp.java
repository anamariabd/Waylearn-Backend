package com.app.waylearn.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class DocumentServiceImp implements DocumentService {

	private final Path rootFolder = Paths.get("uploads");
	
	@Override
	public void save(MultipartFile file) throws Exception {
		Files.copy(file.getInputStream(), this.rootFolder.resolve(file.getOriginalFilename()) );
		
		
	}

	@Override
	public void load(String name) throws Exception {
		// TODO Auto-generated method stub
	
	}

}
