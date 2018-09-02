package com.revatue.Project2.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revatue.Project2.beans.User;
import com.revatue.Project2.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	UserRepo uRep;
	
	public Optional<User> getUser(int id) {
		System.out.println("service -getUser");
		return uRep.findById(id);
		
	}
	
	public Optional<User> testUser(String username, String password) {
		System.out.println("Service ---user");
		Optional<User> y = uRep.findByUsernameAndPassword(username, password);
		return y;
	}
	
	
	

}
