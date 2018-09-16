package com.revature.repo;

import org.springframework.data.repository.CrudRepository;

import com.revature.beans.Picture;

public interface PictureRepo extends CrudRepository<Picture, Integer> {
	
	

}
