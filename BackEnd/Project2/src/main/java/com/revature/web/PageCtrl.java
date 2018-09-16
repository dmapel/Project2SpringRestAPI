package com.revature.web;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Page;
import com.revature.beans.PageTags;
import com.revature.beans.Picture;
import com.revature.beans.Tag;
import com.revature.service.PageService;

@CrossOrigin
@RestController
public class PageCtrl {

	@Autowired
	PageService pServ;

	@PostMapping("/create/page")
	public ResponseEntity<Page> createPage(@RequestBody Page body) {
		body = pServ.createPage(body);
		return new ResponseEntity<>(body, HttpStatus.CREATED);
	}

	@PostMapping("/add/tag")
	public ResponseEntity<Set<PageTags>> addTag(@RequestBody Set<PageTags> body) {
		body = pServ.addTag(body);
		return new ResponseEntity<Set<PageTags>>(body, HttpStatus.CREATED);
	}
	
	@PostMapping("/add/picture")
	public ResponseEntity<Set<Picture>> addPics(@RequestBody Set<Picture> pics){
		pics = pServ.addPics(pics);
		return new ResponseEntity<Set<Picture>>(pics, HttpStatus.CREATED);
	}

	@PutMapping("/edit/page")
	public ResponseEntity<Page> editPage(@RequestBody Page p) {
		Page res = pServ.editPage(p);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@GetMapping("/get/allpages")
	public ResponseEntity<Iterable<Page>> allPages() {
		Iterable<Page> p = pServ.allPages();
		return new ResponseEntity<>(p, HttpStatus.OK);
	}

	@GetMapping("/page/search/{title}")
	public ResponseEntity<List<Page>> findPage(@PathVariable int title) {
		List<Page> p = pServ.findPage(title);
		if (p == null || p.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(p, HttpStatus.OK);
		}
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<HttpStatus> err(Exception ex) {
		HttpStatus res = HttpStatus.INTERNAL_SERVER_ERROR;
		if (ex instanceof DataIntegrityViolationException) {
			res = HttpStatus.BAD_REQUEST;
		}
		return new ResponseEntity<>(res);

	}

}
