package com.app.waylearn.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.waylearn.Entities.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Long>{
	User findByEmail(String email);
}
