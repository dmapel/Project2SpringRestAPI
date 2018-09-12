package com.revature.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Page;
import com.revature.beans.PageTags;
import com.revature.service.PageService;

@RestController
public class PageCtrl {
	
	@Autowired
	PageService pServ;
	
	@PostMapping("/create/page")
	public ResponseEntity<Page> createPage(@RequestBody Page body) {
        System.out.println("Incoming is " + body);
		body =  pServ.createPage(body);
		return new ResponseEntity<Page>(body, HttpStatus.CREATED);
	}
	
	@PostMapping("/add/tag")
	public ResponseEntity<PageTags> addTag(@RequestBody PageTags body){
		System.out.println(body);
		body = pServ.addTag(body);
		return new ResponseEntity<PageTags>(body, HttpStatus.CREATED);
	}
		
	@PutMapping("/edit/page")
	public ResponseEntity<Page> editPage(@RequestBody Page body){
		
		
		Page p = pServ.editPage(body);
		
		return new ResponseEntity<>(p, HttpStatus.OK);
	}
	@GetMapping("/get/allpages")
	public ResponseEntity<Iterable<Page>> allPages(){
		Iterable<Page> p = pServ.allPages();
		System.out.println(p);
		return new ResponseEntity<>(p, HttpStatus.OK);
	}
	
	@GetMapping("/page/search/{title}")
	public ResponseEntity<List<Page>> findPage(@PathVariable String title) {
		List<Page> p = pServ.findPage(title);
		if(p == null || p.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
		return new ResponseEntity<>(p, HttpStatus.OK);
		}
	}
	
	

}
