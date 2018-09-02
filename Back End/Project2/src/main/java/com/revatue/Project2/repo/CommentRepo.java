package com.revatue.Project2.repo;

import org.springframework.data.repository.CrudRepository;

import com.revatue.Project2.beans.Comments;

public interface CommentRepo extends CrudRepository<Comments, Integer>{

}
