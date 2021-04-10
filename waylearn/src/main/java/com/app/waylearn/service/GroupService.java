package com.app.waylearn.service;

import java.util.List;

import com.app.waylearn.Entities.Grupo;

public interface GroupService {

	public Grupo save (Grupo group);
	
	public Grupo findById(Long id);
	
	public List<Grupo> findAll();
	
	public Boolean delete(Long id) throws Exception;
	
	
	
}
