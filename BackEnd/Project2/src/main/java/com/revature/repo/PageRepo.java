package com.revature.repo;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Page;

@Repository("pageRepo")
public interface PageRepo extends PagingAndSortingRepository<Page, Integer>{
	
	
	Page findAllByTitleAndPageStatus(String title, int pageStatus);

}
