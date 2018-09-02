package com.revatue.Project2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.revatue.Project2.beans.Page;
import com.revatue.Project2.beans.User;
import com.revatue.Project2.repo.UserRepo;

@SpringBootApplication
public class UserService {
	
	@Autowired
	UserRepo uRep;
	
	public Optional<User> getUser(int id) {
		System.out.println("service -getUser");
		return uRep.findById(id);
		
	}
	public List<User> getAllUsers() {
		System.out.println("service -getUser");
		return (List<User>) uRep.findAll();
		
	}
	
	public Optional<User> testUser(String username, String password) {
		System.out.println("Service ---user");
		Optional<User> y = uRep.findByUsernameAndPassword(username, password);
		return y;
	}
	/**
	 * Creates new users in the DB
	 * @param body
	 * @return User
	 */
	public User createUser(User body) {
		uRep.save(body);
		return body;
	}
	
	
	
	public void promoteUser(User id) {
		uRep.save(id);
		
	}
	
	
	

}
