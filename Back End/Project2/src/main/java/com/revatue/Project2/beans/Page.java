package com.revatue.Project2.beans;

import java.sql.Clob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PAGES")
public class Page {

	@Id
	//@SequenceGenerator(name = "USER_SEQ", sequenceName = "USER_SEQ", allocationSize = 1)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQ")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PAGE_ID")
	private int pageId;
	
	@Column(name = "CREATED_BY_ID")
	private int creatorId;
	
	@Column(name = "SUMMARY")
	private Clob summary;
	
	@Column(name = "BODY")
	private Clob body;
	
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

	public Page(int pageId, int creatorId, Clob summary, Clob body, int tagId, int pageStatus, String time) {
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

	public Clob getSummary() {
		return summary;
	}

	public void setSummary(Clob summary) {
		this.summary = summary;
	}

	public Clob getBody() {
		return body;
	}

	public void setBody(Clob body) {
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
	
	
}
