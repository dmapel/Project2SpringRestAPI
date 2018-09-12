package com.revature.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PAGE_TAGS")
public class PageTags implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8623437221808519974L;

	
	
	public PageTags() {
		super();
	}

	public PageTags(int pageId, int tagId) {
		super();
		this.pageId = pageId;
		this.tagId = tagId;
	}
    @Id
	@Column(name = "PAGE_ID")
	private int pageId;
	
	@Column(name = "TAG_ID")
	private int tagId;

	public int getPageId() {
		return pageId;
	}

	public void setPageId(int pageId) {
		this.pageId = pageId;
	}

	public int getTagId() {
		return tagId;
	}

	public void setTagId(int tagId) {
		this.tagId = tagId;
	}

	@Override
	public String toString() {
		return "PageTags [pageId=" + pageId + ", tagId=" + tagId + "]";
	}

	
}
