package com.revatue.Project2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.revatue.Project2.beans.Comments;
import com.revatue.Project2.repo.CommentRepo;

@SpringBootApplication
public class CommentService {

	@Autowired
	CommentRepo cRep;

	public Comments createComment(Comments body) {
		cRep.save(body);
		return body;

	}
	public Comments editComment(Comments body) {
		cRep.save(body);
		System.out.println("BODY IS " + body);
		return body;
		
	}
	
	public List<Comments> getAllComments(int pageId) {
		
		
		return cRep.findByPageIdAndCommentStatus(pageId, 1);
	}

}
