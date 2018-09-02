package com.revatue.Project2.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revatue.Project2.beans.Comments;
import com.revatue.Project2.beans.Page;
import com.revatue.Project2.service.CommentService;

@RestController
public class CommentCtrl {
	
	@Autowired
	CommentService cServ;

	@PostMapping("/create/comment")
	public ResponseEntity<Comments> createComment(@RequestBody Comments body) {
		System.out.println(body);
		body =  cServ.createComment(body);
		return new ResponseEntity<Comments>(body, HttpStatus.CREATED);
	}

}
