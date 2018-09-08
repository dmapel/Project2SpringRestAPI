package com.revature.web;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Page;
import com.revature.beans.User;
import com.revature.service.UserService;

@RestController
public class LoginCtrl {
	
	@Autowired
	UserService uServ;

	
	@GetMapping("/login/{id}")
	public Optional<User> login(@PathVariable int id){
		
		Optional<User> u = uServ.getUser(id);
		return u;
	}
	@GetMapping("/get/allusers")
	public List<User> getAllUsers(){
		List<User> u = uServ.getAllUsers();
		return u;
	}
	
	@PostMapping("/login/user")
	public Optional<User> testLogin(@RequestBody Map<String, String> body){
		String username = body.get("username");
		String password = body.get("password");
		Optional<User> x = uServ.testUser(username, password);
		return x;
		
	}
	@PostMapping("/create/user")
	public ResponseEntity<User> createUser(@RequestBody User body) {
		body =  uServ.createUser(body);
		return new ResponseEntity<User>(body, HttpStatus.CREATED);
	}
	
	@PutMapping("/update/user")
	public ResponseEntity<User> promoteUser(@RequestBody User body) {
		User u = new User();
		BeanUtils.copyProperties(body, u);
		uServ.promoteUser(u);
		
		User obj = new User();
		BeanUtils.copyProperties(u, obj);
		return new ResponseEntity<User>(obj, HttpStatus.OK);
	}
	
	
	
}
