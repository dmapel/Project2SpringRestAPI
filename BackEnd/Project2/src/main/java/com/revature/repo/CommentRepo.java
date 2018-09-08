package com.revature.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.revature.beans.Comments;

public interface CommentRepo extends CrudRepository<Comments, Integer>{
	
	 List<Comments> findByPageIdAndCommentStatus(int pageId, int commentStatus);

}
