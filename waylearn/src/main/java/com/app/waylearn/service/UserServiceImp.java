package com.app.waylearn.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.waylearn.Entities.User;
import com.app.waylearn.Repositories.UserRepository;

@Service
public class UserServiceImp implements UserService{

	@Autowired
	private UserRepository repoUser;
	
	@Override
	public User findByEmail(String email) throws Exception{
		
	Optional<User> us = repoUser.findByEmail(email);
		if (us.isPresent() ) {
			return us.get();
		}else {
			throw new Exception("usuario no encontrado");
		}
		
	}

	@Override
	public Boolean existsByEmail(String email) {
		
		return repoUser.existsByEmail(email);
	}

	
	
}
