package com.revature.beans;

import java.time.LocalDateTime;

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

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "COMMENTS")
public class Comments {

	@Id
	@SequenceGenerator(name = "NEW_COMMENT_SEQ", sequenceName = "NEW_COMMENT_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NEW_COMMENT_SEQ")
	@Column(name = "COMMENT_ID")
	private int cId;

	@Column(name = "U_ID")
	private int uId;

	@Column(name = "TIMESUBMISSION")
	@UpdateTimestamp
	private LocalDateTime time;

	@Column(name = "PAGE_ID")
	private int pageId;

	@Column(name = "CONTENT")
	private String content;

	@Column(name = "COMMENT_STATUS_ID")
	private int commentStatus = 1;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "PAGE_ID", insertable = false, updatable = false)
	private Page allComments;


	public Comments() {
		super();

	}

	public Comments(int cId, int uId, LocalDateTime time, int pageId, String content, int commentStatus) {
		super();
		this.cId = cId;
		this.uId = uId;
		this.time = time;
		this.pageId = pageId;
		this.content = content;
		this.commentStatus = commentStatus;
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

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public int getPageId() {
		return pageId;
	}

	public void setPageId(int pageId) {
		this.pageId = pageId;
	}

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
	
	@Override
	public String toString() {
		return "[cId=" + cId + ", uId=" + uId + ", time=" + time + ", content=" + content + ", commentStatus="
				+ commentStatus + "]";
	}

}
