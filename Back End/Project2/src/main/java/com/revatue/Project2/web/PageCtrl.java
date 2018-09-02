package com.revatue.Project2.web;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revatue.Project2.beans.Page;
import com.revatue.Project2.service.PageService;

@RestController
public class PageCtrl {
	
	@Autowired
	PageService pServ;
	
	@PostMapping("/create/page")
	public ResponseEntity<Page> createPage(@RequestBody Page body) {
		System.out.println(body);
		body =  pServ.createPage(body);
		return new ResponseEntity<Page>(body, HttpStatus.CREATED);
	}
		
	@PutMapping("delete/page")
	public ResponseEntity<Page> deletePage(@RequestBody Page body){
		System.out.println("Deleting page " + body);
		Page p = new Page();
		BeanUtils.copyProperties(body, p);
		pServ.deletePage(p);
		
		Page obj = new Page();
		BeanUtils.copyProperties(p, obj);
		
		return new ResponseEntity<Page>(obj, HttpStatus.OK);
	}

}
