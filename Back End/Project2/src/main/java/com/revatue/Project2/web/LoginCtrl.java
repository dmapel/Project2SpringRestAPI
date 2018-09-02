package com.revatue.Project2.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.revatue.Project2.beans.User;
import com.revatue.Project2.service.UserService;

@Controller
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
}
