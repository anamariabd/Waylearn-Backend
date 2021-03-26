package com.app.waylearn.Security;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;


import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.security.core.userdetails.User;

import com.app.waylearn.service.UserService;

public class UserDetailsServiceImpl implements UserDetailsService {
 
	
	@Autowired
	private UserService userServeces;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			com.app.waylearn.Entities.User us = userServeces.findByEmail(username);
			
			if (us.getEmail().equals(username)) {
				return UserBuilder(us.getEmail(), us.getPassword(), us.getRole().getRol());
			}else {
				throw new UsernameNotFoundException("Usuario no encontrado");
			}
		} catch (Exception e) {
			e.getCause();
			return null;
		}
		
		
	}
	
	
	private UserDetails UserBuilder(String email,String password, String rol) {
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean AccountNonLocked = true;
		GrantedAuthority authorities  = new SimpleGrantedAuthority("ROLE_"+ rol);
		UserDetails uss = (UserDetails) new User(email,password,enabled,accountNonExpired,credentialsNonExpired,AccountNonLocked,(Collection<? extends GrantedAuthority>) authorities);
		return uss;
	}

}
