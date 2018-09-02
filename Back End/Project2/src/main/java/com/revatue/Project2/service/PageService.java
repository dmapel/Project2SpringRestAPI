package com.revatue.Project2.service;

import javax.sql.rowset.serial.SerialClob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.revatue.Project2.beans.Page;
import com.revatue.Project2.repo.PageRepo;

@SpringBootApplication
public class PageService {

	@Autowired
	PageRepo pRep;
	
	public Page createPage(Page body) {
		System.out.println("Saving " + body);
		
		pRep.save(body);
		System.out.println("Saved " + body);
		return body;
	}
	
	public void deletePage(Page body) {
		pRep.save(body);
	}
}
