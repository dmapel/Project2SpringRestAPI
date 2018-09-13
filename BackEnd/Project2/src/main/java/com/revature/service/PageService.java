package com.revature.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.revature.beans.Page;
import com.revature.beans.PageTags;
import com.revature.beans.Tag;
import com.revature.repo.PageRepo;
import com.revature.repo.PageTagsRepo;
import com.revature.repo.TagRepo;

@SpringBootApplication
public class PageService {

	String correctPage;
	
	
	@Autowired
	PageTagsRepo ptRep;
	
	@Autowired
	PageRepo pRep;
	
	@Autowired
	TagRepo tRep;
	
	

	public Page createPage(Page body) {
		Page x = pRep.save(body);
		return body;
	}
	
	public Set<PageTags> addTag(Set<PageTags> pt) {
		ptRep.saveAll(pt);
		return pt;
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
	
	public Set<Tag> addingTags(int id) {
		System.out.println(id);
		Set<Tag> i = findTags(id);
		System.out.println(i);
		return i;
	}
	
	public Set<Tag> findTags(int id) {
		Set<Tag> pt = tRep.findByTagId(id);
		System.out.println("PT IS " + pt);
		return pt;
	}
}
