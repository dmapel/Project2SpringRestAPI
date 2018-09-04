package com.revatue.Project2.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.revatue.Project2.beans.Comments;

public interface CommentRepo extends CrudRepository<Comments, Integer>{
	
	 List<Comments> findByPageIdAndCommentStatus(int pageId, int commentStatus);

}
