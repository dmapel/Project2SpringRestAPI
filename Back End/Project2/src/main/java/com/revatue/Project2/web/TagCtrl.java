package com.revatue.Project2.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revatue.Project2.beans.Page;
import com.revatue.Project2.beans.Tag;
import com.revatue.Project2.service.TagService;

@RestController
public class TagCtrl {

	@Autowired
	TagService tServ;
	
	@PostMapping("/create/tag")
	public ResponseEntity<Tag> createTag(@RequestBody Tag body) {
		System.out.println(body);
		body =  tServ.createTag(body);
		return new ResponseEntity<Tag>(body, HttpStatus.CREATED);
		
	}
}
