package com.revature.beans;

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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "PICTURE")
public class Picture {

	@Id
	@SequenceGenerator(name = "NEW_PIC_SEQ", sequenceName = "NEW_PIC_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NEW_PIC_SEQ")
	@Column(name = "PIC_ID")
	private int picId;
	
	@Column(name = "PIC")
	private String picLink;
	
	@Column(name = "PAGE_ID")
	private int pageId;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "PAGE_ID", insertable = false, updatable = false)
	private Page pics;
	

	public Picture() {
		super();
	}

	public Picture(int picId, String picLink, int pageId) {
		super();
		this.picId = picId;
		this.picLink = picLink;
		this.pageId = pageId;
	}


	public int getPicId() {
		return picId;
	}

	public void setPicId(int picId) {
		this.picId = picId;
	}

	public String getPicLink() {
		return picLink;
	}

	public void setPicLink(String picLink) {
		this.picLink = picLink;
	}

	public int getPageId() {
		return pageId;
	}

	public void setPageId(int pageId) {
		this.pageId = pageId;
	}

	@Override
	public String toString() {
		return "Picture [picId=" + picId + ", picLink=" + picLink + ", pageId=" + pageId + "]";
	}
	
	
}
