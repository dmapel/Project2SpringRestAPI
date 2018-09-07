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
		
		pRep.save(body);
		return body;
	}
	
	public Page deletePage(Page body) {
		return pRep.save(body);
	}
}
