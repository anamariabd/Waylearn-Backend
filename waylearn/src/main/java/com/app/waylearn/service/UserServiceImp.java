package com.app.waylearn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.app.waylearn.Entities.User;
import com.app.waylearn.Repositories.UserRepository;

public class UserServiceImp implements UserService{

	@Autowired
	private UserRepository repoUser;
	
	@Override
	public User findByEmail(String email) throws Exception{
		
		User us = repoUser.findByEmail(email);
		if (us != null) {
			return us;
		}else {
			throw new Exception("usuario no encontrado");
		}
		
	}

	
	
}
