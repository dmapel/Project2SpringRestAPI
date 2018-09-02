package com.revatue.Project2.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revatue.Project2.beans.User;

@Repository("userRepo")
public interface UserRepo extends JpaRepository<User, Integer>{
	
	
	Optional<User> findByUsernameAndPassword(String username, String password);
	

}
