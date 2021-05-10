package com.app.waylearn.Repositories;

import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.app.waylearn.Entities.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {

	Document findByName(String name);
	@Query("select true from Document d where d.name = :Objname")
	Boolean existByName(@Param("Objname") String  name);
	
}
