package com.revatue.Project2.web;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revatue.Project2.beans.Comments;
import com.revatue.Project2.service.CommentService;

@RestController
public class CommentCtrl {

	@Autowired
	CommentService cServ;

	@PostMapping("/create/comment")
	public ResponseEntity<Comments> createComment(@RequestBody Comments body) {
		System.out.println(body);
		body = cServ.createComment(body);
		return new ResponseEntity<Comments>(body, HttpStatus.CREATED);
	}

	@PutMapping("/edit/comment")
	public ResponseEntity<Comments> deleteOrEditComment(@RequestBody Comments body) {
		System.out.println(body);
		Comments c = new Comments();
		BeanUtils.copyProperties(body, c);
		cServ.editComment(c);

		Comments obj = new Comments();
		BeanUtils.copyProperties(c, obj);
		return new ResponseEntity<Comments>(obj, HttpStatus.OK);
	}

	@GetMapping("/page/{pageId}/comments")
	public Comments getAllComments(@PathVariable int pageId) {
		System.out.println("Retreveing all from " + pageId);
		Comments res = cServ.getAllComments(pageId);
		System.out.println(res);
		return res;

//		System.out.println("Retreving all comments " + pageId);
//		Optional<Comments> c = cServ.getAllComments(pageId);
//		System.out.println(c);
//		return c;

	}

	/*
	 * @GetMapping("/posts/{postId}/comments") public Page<Comment>
	 * getAllCommentsByPostId(@PathVariable (value = "postId") Long postId, Pageable
	 * pageable) { return commentRepository.findByPostId(postId, pageable); }
	 */

}
