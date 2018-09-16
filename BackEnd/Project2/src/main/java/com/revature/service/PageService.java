package com.revature.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.revature.beans.Page;
import com.revature.beans.PageTags;
import com.revature.beans.Picture;
import com.revature.beans.Tag;
import com.revature.repo.PageRepo;
import com.revature.repo.PageTagsRepo;
import com.revature.repo.PictureRepo;
import com.revature.repo.TagRepo;

@Service
@Component("pageService")
public class PageService {

	@Autowired
	PageTagsRepo ptRep;

	@Autowired
	PageRepo pRep;

	@Autowired
	TagRepo tRep;

	@Autowired
	PictureRepo picRep;

	public Page createPage(Page body) {
		return pRep.save(body);
	}

	public Set<PageTags> addTag(Set<PageTags> pt) {
		ptRep.saveAll(pt);
		return pt;
	}

	public Set<Picture> addPics(Set<Picture> pics) {
		picRep.saveAll(pics);
		return pics;
	}

	public Page editPage(Page body) {
		return pRep.save(body);
	}

	public Iterable<Page> allPages() {
		return pRep.findAll();
	}

	public List<Page> findPage(int id) {
		return pRep.findByPageIdAndPageStatus(id, 1);
	}

	public Set<Tag> addingTags(int id) {
		return findTags(id);
	}

	public Set<Tag> findTags(int id) {
		return tRep.findByTagId(id);
	}

	public List<List<Page>> findByTags(String tags[]) {
		List<List<Page>> pages = new ArrayList<List<Page>>();
		for (int i = 0; i < tags.length; i++) {
			List<PageTags> x = ptRep.findAllBytagId(Integer.parseInt(tags[i]));
			for(int b = 0; b < x.size(); b++) {
				int y = x.get(b).getPageId();
				List<Page> m = pRep.findAllByPageId(y);
				pages.add(m);
			}
			
			
		}
		System.out.println(pages);

		return pages;
	}

}
