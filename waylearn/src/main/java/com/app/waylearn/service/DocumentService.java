package com.app.waylearn.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface DocumentService {
	
	public void save(MultipartFile file) throws Exception;
	
	public void  load (String name) throws Exception;
}
