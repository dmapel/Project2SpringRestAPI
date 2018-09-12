package com.revature.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Page;

@Repository("pageRepo")
public interface PageRepo extends JpaRepository<Page, Integer>{
	
	
	List<Page> findAllByTitleAndPageStatus(String title, int pageStatus);
	
	List<Page> findAllByTitle(String title);

}
