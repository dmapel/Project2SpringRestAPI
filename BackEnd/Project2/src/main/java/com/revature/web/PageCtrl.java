package com.revature.web;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.revature.beans.Tag;
import com.revature.service.PageService;

@CrossOrigin
@RestController
public class PageCtrl {

	@Autowired
	PageService pServ;

	@PostMapping("/create/page")
	public ResponseEntity<Page> createPage(@RequestBody Page body) {
		System.out.println("Incoming is " + body);

		body = pServ.createPage(body);

		return new ResponseEntity<>(body, HttpStatus.CREATED);
	}

	@PostMapping("/add/tag")
	public ResponseEntity<Set<PageTags>> addTag(@RequestBody Set<PageTags> body) {
		System.out.println(body);
		body = pServ.addTag(body);
		return new ResponseEntity<Set<PageTags>>(body, HttpStatus.CREATED);
	}

	@PutMapping("/edit/page")
	public ResponseEntity<Page> editPage(@RequestBody Map body) {
		Page p = new Page();
		//List<Tag> x = (List<Tag>) body.get("tags");
		//pServ.parseList(x); future ease need to be here
		//System.out.println("x is " + x);
		int tag = (int) body.get("tagId");
		p.setPageId((int) body.get("pageId"));
		p.setCreatorId((int) body.get("creatorId"));
		p.setTitle((String) body.get("title"));
		p.setSummary((String) body.get("summary"));
		p.setBody((String) body.get("body"));
		Set<Tag> pt = pServ.addingTags(tag);
		p.setTags(pt);
		Page res = pServ.editPage(p);
		System.out.println(body);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@GetMapping("/get/allpages")
	public ResponseEntity<Iterable<Page>> allPages() {
		Iterable<Page> p = pServ.allPages();
		System.out.println(p);
		return new ResponseEntity<>(p, HttpStatus.OK);
	}

	@GetMapping("/page/search/{title}")
	public ResponseEntity<List<Page>> findPage(@PathVariable String title) {
		List<Page> p = pServ.findPage(title);
		if (p == null || p.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(p, HttpStatus.OK);
		}
	}

	@ExceptionHandler(Exception.class)
	public HttpStatus err() {
		return HttpStatus.NOT_FOUND;
	}

}
