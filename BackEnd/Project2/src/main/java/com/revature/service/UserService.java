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
	
	public int sum(int[] numbers) {
        int sum = 0;
        for (int i: numbers) {
            sum += i;
        }
        return sum;
    }
	
	public User getUser(int id) {
		return uRep.findByUId(id);
		
	}
	public List<User> getAllUsers() {
		return (List<User>) uRep.findAll();
		
	}
	
	public Optional<User> testUser(String username, String password) {
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
	
	
	
	public User promoteUser(User id) {
		return uRep.save(id);
		
	}
	
	
	

}
