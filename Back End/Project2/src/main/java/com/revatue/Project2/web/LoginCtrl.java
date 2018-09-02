package com.revatue.Project2.web;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revatue.Project2.beans.User;
import com.revatue.Project2.service.UserService;

@RestController
public class LoginCtrl {
	
	@Autowired
	UserService uServ;

	
	@GetMapping("/login/{id}")
	public Optional<User> login(@PathVariable int id){
		
		System.out.println("Login attempted..." + id);
		Optional<User> u = uServ.getUser(id);
		System.out.println(u);
		return u;
	}
	
	@PostMapping("/login/user")
	public Optional<User> testLogin(@RequestBody Map<String, String> body){
		System.out.println("testing login..." + body);
		String username = body.get("username");
		String password = body.get("password");
		System.out.println(username);
		System.out.println(password);
		Optional<User> x = uServ.testUser(username, password);
		System.out.println(x);
		return x;
		
	}
}
