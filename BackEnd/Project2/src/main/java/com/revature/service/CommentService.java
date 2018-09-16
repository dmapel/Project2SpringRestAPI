package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Comments;
import com.revature.repo.CommentRepo;

@Service
public class CommentService {

	@Autowired
	CommentRepo cRep;

	public Comments createComment(Comments body) {
		return cRep.save(body);

	}
	public Comments editComment(Comments body) {
		return cRep.save(body);
		
	}
	
	public List<Comments> getAllComments(int pageId) {
		return cRep.findByPageIdAndCommentStatus(pageId, 1);
	}

}
