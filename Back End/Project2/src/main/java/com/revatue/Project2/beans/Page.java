package com.revatue.Project2.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name = "PAGES")
public class Page {

	@Id
	@SequenceGenerator(name = "NEW_PAGE_SEQ", sequenceName = "NEW_PAGE_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NEW_PAGE_SEQ")
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PAGE_ID")
	private int pageId;
	
	@OneToMany(mappedBy="comments", fetch=FetchType.LAZY)
	private Set<Comments> pageComments = new HashSet<Comments>();
	
	@Column(name = "CREATED_BY_ID")
	private int creatorId;
	

	@Column(name = "SUMMARY", columnDefinition= "CLOB")
	@Lob
	private String summary;
	
	
	@Column(name = "BODY", columnDefinition= "CLOB")
	@Lob
	private String body;
	
	@Column(name = "TAG_ID")
	private int tagId;
	
	@Column(name = "PAGE_STATUS_ID")
	private int pageStatus;
	
	@Column(name = "TIMESUBMISSION")
	private String time;

	public Page() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Page(int pageId, int creatorId, String summary, String body, int tagId, int pageStatus, String time) {
		super();
		this.pageId = pageId;
		this.creatorId = creatorId;
		this.summary = summary;
		this.body = body;
		this.tagId = tagId;
		this.pageStatus = pageStatus;
		this.time = time;
	}

	@Override
	public String toString() {
		return "Page [pageId=" + pageId + ", creatorId=" + creatorId + ", summary=" + summary + ", body=" + body
				+ ", tagId=" + tagId + ", pageStatus=" + pageStatus + ", time=" + time + "]";
	}

	public int getPageId() {
		return pageId;
	}

	public void setPageId(int pageId) {
		this.pageId = pageId;
	}

	public int getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(int creatorId) {
		this.creatorId = creatorId;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public int getTagId() {
		return tagId;
	}

	public void setTagId(int tagId) {
		this.tagId = tagId;
	}

	public int getPageStatus() {
		return pageStatus;
	}

	public void setPageStatus(int pageStatus) {
		this.pageStatus = pageStatus;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Set<Comments> getPageComments() {
		return pageComments;
	}

	public void setPageComments(Set<Comments> pageComments) {
		this.pageComments = pageComments;
	}
	
	
	
	
}
