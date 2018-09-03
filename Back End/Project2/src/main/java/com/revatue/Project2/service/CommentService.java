package com.revatue.Project2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.revatue.Project2.beans.Comments;
import com.revatue.Project2.beans.Page;
import com.revatue.Project2.repo.CommentRepo;

@SpringBootApplication
public class CommentService {

	@Autowired
	CommentRepo cRep;

	public Comments createComment(Comments body) {
		cRep.save(body);
		return body;

	}
	public void editComment(Comments body) {
		cRep.save(body);
		
	}

}
