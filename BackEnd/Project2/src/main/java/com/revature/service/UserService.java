package com.revature.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.User;
import com.revature.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	UserRepo uRep;
	
	public User getUser(int id) {
		return uRep.findByUId(id);
		
	}
	public List<User> getAllUsers() {
		return (List<User>) uRep.findAll();
		
	}
	
	public Optional<User> testUser(String username, String password) {
		return uRep.findByUsernameAndPassword(username, password);
	}
	
	public User createUser(User body) {
		uRep.save(body);
		return body;
	}
	
	public User editUser(User id) {
		User u = uRep.findByUId(id.getuId());
		u.setPosId(id.getPosId());
		if(id.getfName() != null) {
			u.setfName(id.getfName());
		}
		if(id.getlName() != null) {
			u.setlName(id.getlName());
		}
		if(id.getUsername()!= null) {
			u.setUsername(id.getUsername());
		}
		if(id.getPassword()!= null) {
			u.setPassword(id.getPassword());
		}
		uRep.save(u);
		return u;
		
	}
	
	
	

}
