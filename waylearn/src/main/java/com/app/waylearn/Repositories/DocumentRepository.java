package com.app.waylearn.Repositories;

import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.app.waylearn.Entities.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {

	
	
}
