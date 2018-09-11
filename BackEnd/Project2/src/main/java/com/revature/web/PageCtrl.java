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
		
	@PutMapping("edit/page")
	public Page deletePage(@RequestBody Page body){

		Page p = pServ.deletePage(body);

		
		return p;
	}
	
	@GetMapping("page/search/{title}")
	public Page findPage(@PathVariable String title) {
		System.out.println("Searching for title results...." + title);
		
		return pServ.findPage(title);
		
	}

}
