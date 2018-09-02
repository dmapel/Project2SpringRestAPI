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
		System.out.println("Saving " + body);
		cRep.save(body);
		System.out.println("Saved " + body);
		return body;

	}

}
