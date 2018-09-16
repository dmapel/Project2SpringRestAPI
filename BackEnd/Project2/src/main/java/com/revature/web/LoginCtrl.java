package com.revature.web;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.User;
import com.revature.service.UserService;

@CrossOrigin
@RestController
public class LoginCtrl {

	@Autowired
	UserService uServ;

	@GetMapping("/login/{id}")
	public ResponseEntity<User> login(@PathVariable int id) {
		User u = uServ.getUser(id);
		if (u == null) {
			return new ResponseEntity<>(u, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(u, HttpStatus.OK);
		}
	}

	@GetMapping("/get/allusers")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> u = uServ.getAllUsers();
		if (u == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(u, HttpStatus.OK);
		}
	}

	@PostMapping("/login/user")
	public ResponseEntity<Optional<User>> testLogin(@RequestBody Map<String, String> body) {
		String username = body.get("username");
		String password = body.get("password");
		Optional<User> x = uServ.testUser(username, password);
		return new ResponseEntity<>(x, HttpStatus.ACCEPTED);

	}

	@PostMapping("/create/user")
	public ResponseEntity<User> createUser(@RequestBody User body) {
		body = uServ.createUser(body);
		return new ResponseEntity<>(body, HttpStatus.CREATED);
	}

	@PutMapping("/update/user")
	public ResponseEntity<User> promoteUser(@RequestBody User body) {
<<<<<<< HEAD
		User u = uServ.promoteUser(body);
		System.out.println(u);
		
=======
		User u = uServ.editUser(body);

>>>>>>> finishing-touches
		return new ResponseEntity<>(u, HttpStatus.OK);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<HttpStatus> err(Exception ex) {
		HttpStatus res = HttpStatus.INTERNAL_SERVER_ERROR;
		if (ex instanceof DataIntegrityViolationException) {
			res = HttpStatus.BAD_REQUEST;
		}
		return new ResponseEntity<>(res);

	}

}
