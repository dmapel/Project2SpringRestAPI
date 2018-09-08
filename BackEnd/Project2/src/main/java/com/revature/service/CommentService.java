package com.revature.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.revature.beans.Comments;
import com.revature.repo.CommentRepo;

@SpringBootApplication
public class CommentService {

	@Autowired
	CommentRepo cRep;

	public Comments createComment(Comments body) {
		cRep.save(body);
		return body;

	}
	public Comments editComment(Comments body) {
		return cRep.save(body);
		
	}
	
	public List<Comments> getAllComments(int pageId) {
		
		
		return cRep.findByPageIdAndCommentStatus(pageId, 1);
	}

}
