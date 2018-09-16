package com.revature.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.revature.beans.Page;
import com.revature.beans.PageTags;
import com.revature.beans.Picture;
import com.revature.beans.Tag;
import com.revature.repo.PageRepo;
import com.revature.repo.PageTagsRepo;
import com.revature.repo.PictureRepo;
import com.revature.repo.TagRepo;

@Service
@Component("pageService")
public class PageService {

	String correctPage;
	
	@Autowired
	PageTagsRepo ptRep;
	
	@Autowired
	PageRepo pRep;
	
	@Autowired
	TagRepo tRep;
	
	@Autowired
	PictureRepo picRep;
	

	public Page createPage(Page body) {
		Page x = pRep.save(body);
		return x;
	}
	
	public Set<PageTags> addTag(Set<PageTags> pt) {
		ptRep.saveAll(pt);
		return pt;
	}
	
	public Set<Picture> addPics(Set<Picture> pics){
		picRep.saveAll(pics);
		return pics;
	}
	
	public Page editPage(Page body) {
		return pRep.save(body);
	}
	
	public Iterable<Page> allPages(){
		
		return pRep.findAll();
	}

	public List<Page> findPage(int id) {


		return pRep.findByPageIdAndPageStatus(id, 1);
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
	
	public int parseList(List<String> x) {
		int y = 0; 
		System.out.println("LIST IS " + x);
		
		for (int i = 0; i < x.size(); i++) {
			y = x.size();
			System.out.println("x " + i + " is: " + y);
		}
		return y;
	}
}
