package com.revature.web;

import java.util.List;

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

import com.revature.beans.Comments;
import com.revature.service.CommentService;

@CrossOrigin
@RestController
public class CommentCtrl {

	@Autowired
	CommentService cServ;

	@PostMapping("/create/comment")
	public ResponseEntity<Comments> createComment(@RequestBody Comments body) {
		body = cServ.createComment(body);
		return new ResponseEntity<>(body, HttpStatus.CREATED);
	}

	@PutMapping("/edit/comment")
	public ResponseEntity<Comments> deleteOrEditComment(@RequestBody Comments body) {
		body = cServ.editComment(body);
		return new ResponseEntity<>(body, HttpStatus.CREATED);
	}

	@GetMapping("/page/{pageId}/comments")
	public ResponseEntity<List<Comments>> getAllComments(@PathVariable int pageId) {
		List<Comments> res = cServ.getAllComments(pageId);
		if(res.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>(res, HttpStatus.OK);
		}

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
