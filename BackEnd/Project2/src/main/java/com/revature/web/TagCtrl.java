package com.revature.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Tag;
import com.revature.service.TagService;

@CrossOrigin
@RestController
public class TagCtrl {

	@Autowired
	TagService tServ;
	
	@PostMapping("/create/tag")
	public ResponseEntity<Tag> createTag(@RequestBody Tag body) {
		body =  tServ.createTag(body);
		return new ResponseEntity<Tag>(body, HttpStatus.CREATED);
	}
	
	@GetMapping("/getall/tags")
	public ResponseEntity<List<Tag>> getAllTags(){
		List<Tag> t = tServ.getAllTags();
		return new ResponseEntity<List<Tag>>(t, HttpStatus.OK);
	}
	
	@ExceptionHandler(Exception.class)
	public HttpStatus err() {
		return HttpStatus.NOT_FOUND;
	}
	
}
