package com.revatue.Project2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.revatue.Project2.beans.Tag;
import com.revatue.Project2.repo.TagRepo;

@SpringBootApplication
public class TagService {

	@Autowired
	TagRepo tRep;
	
	public Tag createTag(Tag body) {
		tRep.save(body);
		return body;
	}
	
	
}
