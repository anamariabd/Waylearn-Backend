package com.app.waylearn.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.waylearn.Controllers.GroupController;
import com.app.waylearn.Entities.Grupo;
import com.app.waylearn.Repositories.GroupRepository;

@Service
public class GroupServiceImp implements GroupService {
	private static Logger log = LoggerFactory.getLogger(GroupService.class);
	@Autowired
	private GroupRepository groupRepository;

	@Override
	public Grupo save(Grupo group) {
	 return groupRepository.save(group);
		
	}

	@Override
	public Grupo findById(Long id) {
	  Optional<Grupo> grp = groupRepository.findById(id);
	  
	  if(!grp.isPresent()) {
		  return null;
	  }
	
	  return grp.get();
	}

	@Override
	public List<Grupo> findAll() {
		return groupRepository.findAll();
	}
	
	@Override
	public void delete(Long id) throws Exception{
		try {
			groupRepository.deleteById(id);
			Grupo grp = groupRepository.getOne(id);
			
		
		}catch (Exception e) {
		 throw new RuntimeException("Error al borrar");
		}	
	}
		
	
}
