package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.revature.beans.Tag;
import com.revature.repo.TagRepo;

@SpringBootApplication
public class TagService {

	@Autowired
	TagRepo tRep;
	
	public Tag createTag(Tag body) {
		tRep.save(body);
		return body;
	}
	
	
}
