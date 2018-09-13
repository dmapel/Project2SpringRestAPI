package com.revature.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.revature.beans.PageTags;
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
