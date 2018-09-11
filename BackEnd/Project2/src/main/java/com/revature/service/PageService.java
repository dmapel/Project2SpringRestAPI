package com.revature.service;

import java.util.List;

import javax.sql.rowset.serial.SerialClob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.revature.beans.Page;
import com.revature.repo.PageRepo;

@SpringBootApplication
public class PageService {

	String correctPage;
	
	@Autowired
	PageRepo pRep;

	public Page createPage(Page body) {
		System.out.println(body);
		Page x = pRep.save(body);
		System.out.println(x);
		return body;
	}

	public Page deletePage(Page body) {
		return pRep.save(body);
	}

	public Page findPage(String title) {

		Iterable<Page> results = pRep.findAll();
		
		results.forEach(p -> {
			if (p.getTitle().contains(title)) {
				correctPage = p.getTitle();
				
			}
		});
		return pRep.findAllByTitleAndPageStatus(correctPage, 2);
	}
}
