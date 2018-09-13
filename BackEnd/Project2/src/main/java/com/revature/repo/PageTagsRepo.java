package com.revature.repo;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.PageTags;
import com.revature.beans.Tag;

@Repository("pageTagsRepo")
public interface PageTagsRepo extends JpaRepository<PageTags, Integer> {
  
	
	//Set<PageTags> findAllByPageId(int id);


}
