package com.revature.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.revature.beans.Page;
import com.revature.beans.PageTags;
import com.revature.beans.Tag;
import com.revature.repo.PageRepo;
import com.revature.repo.PageTagsRepo;
import com.revature.repo.TagRepo;

@SpringBootApplication
@Component("pageService")
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
	
	public void parseList(List<Tag> x) {
		Scanner scanner = new Scanner((Readable) x);
		List<Integer> list = new ArrayList<Integer>();
		while (scanner.hasNextInt()) {
		    list.add(scanner.nextInt());
		}
		System.out.println("LIST IS " + list);
		
//		for (int i = 0; i < x.size(); i++) {
//			int y = x.get(i);
//			System.out.println("x " + i + " is: " + y);
//		}
	}
}
