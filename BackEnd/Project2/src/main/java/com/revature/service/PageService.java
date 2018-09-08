package com.revature.service;

import javax.sql.rowset.serial.SerialClob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.revature.beans.Page;
import com.revature.repo.PageRepo;

@SpringBootApplication
public class PageService {

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
}
