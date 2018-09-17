package com.revature.repo;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Tag;

@Repository("tagRepo")
public interface TagRepo extends JpaRepository<Tag, Integer>{

	public Set<Tag> findByTagId(int id);
	
	
}
