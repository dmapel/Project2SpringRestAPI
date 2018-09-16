package com.revature.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Page;
import com.revature.beans.PageTags;
import com.revature.beans.Tag;

@Repository("pageRepo")
public interface PageRepo extends JpaRepository<Page, Integer>{
	
	
	List<Page> findAllByTitleAndPageStatus(String title, int pageStatus);
	
	List<Page> findByPageIdAndPageStatus(int id, int pageStatus);
	
	List<Page> findAllByTitle(String title);
	
	List<Page> findAllByPageId(int i);
	


	
	

}
