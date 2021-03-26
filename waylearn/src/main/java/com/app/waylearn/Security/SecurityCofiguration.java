package com.app.waylearn.Security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityCofiguration extends  WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetails;
	
	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

	//@Autowired
	//private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	  @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
    }
	  
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		
		auth.userDetailsService(userDetails).passwordEncoder(passwordEncoder());
	}


}

