package com.app.waylearn.service;

import com.app.waylearn.Entities.User;


public interface UserService {
	public User findByEmail(String email) throws Exception;
	public Boolean existsByEmail(String email);
}
