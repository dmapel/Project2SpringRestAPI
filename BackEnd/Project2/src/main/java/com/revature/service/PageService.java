package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.revature.beans.Page;
import com.revature.beans.PageTags;
import com.revature.repo.PageRepo;
import com.revature.repo.PageTagsRepo;

@SpringBootApplication
public class PageService {

	String correctPage;
	
	
	@Autowired
	PageTagsRepo ptRep;
	
	@Autowired
	PageRepo pRep;
	

	public Page createPage(Page body) {
		Page x = pRep.save(body);
		return body;
	}
	
	public PageTags addTag(PageTags body) {
		ptRep.save(body);
		return body;
	}

	public Page editPage(Page body) {
		return pRep.save(body);
	}
	
	public Iterable<Page> allPages(){
		
		return pRep.findAll();
	}

	public List<Page> findPage(String title) {


		return pRep.findAllByTitleAndPageStatus(title, 1);
	}
}
