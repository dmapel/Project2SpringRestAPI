package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Page;
import com.revature.beans.Tag;
import com.revature.repo.TagRepo;

@Service
public class TagService {

	@Autowired
	TagRepo tRep;

	
	public Tag createTag(Tag body) {
		tRep.save(body);
		return body;
	}
	
	public List<Tag> getAllTags(){
		return tRep.findAll();
	}
	
	
	
}
