package com.revatue.Project2.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "COMMENTS")
public class Comments {

	@Id
	@SequenceGenerator(name = "NEW_COMMENT_SEQ", sequenceName = "NEW_COMMENT_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NEW_COMMENT_SEQ")
	// @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "COMMENT_ID")
	private int cId;

	@Column(name = "U_ID")
	private int uId;

	@Column(name = "TIMESUBMISSION")
	private String time;

	@Column(name = "PAGE_ID")
	private int pageId;

	@Column(name = "CONTENT")
	private String content;

	@Column(name = "COMMENT_STATUS_ID")
	private int commentStatus;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "PAGE_ID", insertable = false, updatable = false)
	private Page comments;

//	public Page getComments() {
//		return comments;
//	}
//
//	public void setComments(Page comments) {
//		this.comments = comments;
//	}

	public Comments() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comments(int cId, int uId, String time, int pageId, String content, int commentStatus) {
		super();
		this.cId = cId;
		this.uId = uId;
		this.time = time;
		this.pageId = pageId;
		this.content = content;
		this.commentStatus = commentStatus;
	}

	@Override
	public String toString() {
		return "[cId=" + cId + ", uId=" + uId + ", time=" + time + ", content=" + content + ", commentStatus="
				+ commentStatus + "]";
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

//	public int getPageId() {
//		return pageId;
//	}
//
//	public void setPageId(int pageId) {
//		this.pageId = pageId;
//	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getCommentStatus() {
		return commentStatus;
	}

	public void setCommentStatus(int commentStatus) {
		this.commentStatus = commentStatus;
	}

}
