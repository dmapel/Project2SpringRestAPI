package com.revature.beans;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;



@Entity
@Table(name = "PAGES")
public class Page {

	@Id
	@SequenceGenerator(name = "NEW_PAGE_SEQ", sequenceName = "NEW_PAGE_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NEW_PAGE_SEQ")
	@Column(name = "PAGE_ID")
	private int pageId;
	
	@OneToMany(mappedBy="allComments", fetch=FetchType.LAZY)
	private Set<Comments> pageComments = new HashSet<Comments>();
	
	@Column(name = "CREATED_BY_ID")
	private int creatorId;
	
	@Column(name = "TITLE")
	private String title;
	

	@Column(name = "SUMMARY", columnDefinition= "CLOB")
	@Lob
	private String summary;
	
	
	@Column(name = "BODY", columnDefinition= "CLOB")
	@Lob
	private String body;
	

	@Column(name = "PAGE_STATUS_ID")
	private int pageStatus = 1;
	
	@Column(name = "TIMESUBMISSION")
	@UpdateTimestamp
	private LocalDateTime time;
	
	@ManyToMany(fetch = FetchType.LAZY,cascade= { 
			CascadeType.PERSIST,
			CascadeType.MERGE
			
	})
	@JoinTable(name= "PAGE_TAGS",
	joinColumns = { @JoinColumn(name = "PAGE_ID") },
	inverseJoinColumns = {@JoinColumn(name = "TAG_ID")})
	private Set<Tag> tags = new HashSet<>();
			

	public Page() {
		super();
	}


	public Page(int pageId, Set<Comments> pageComments, int creatorId, String title, String summary, String body,
			int pageStatus, LocalDateTime time, Set<Tag> tags) {
		super();
		this.pageId = pageId;
		this.pageComments = pageComments;
		this.creatorId = creatorId;
		this.title = title;
		this.summary = summary;
		this.body = body;
		this.pageStatus = pageStatus;
		this.time = time;
		this.tags = tags;
	}




	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public int getPageStatus() {
		return pageStatus;
	}

	public void setPageStatus(int pageStatus) {
		this.pageStatus = pageStatus;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public Set<Comments> getPageComments() {
		return pageComments;
	}

	public void setPageComments(Set<Comments> pageComments) {
		this.pageComments = pageComments;
	}
	
	

	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		return "Page [pageId=" + pageId + ", pageComments=" + pageComments + ", creatorId=" + creatorId + ", title="
				+ title + ", summary=" + summary + ", body=" + body + ", pageStatus=" + pageStatus + ", time=" + time
				+ ", tags=" + tags + "]";
	}


	
	

	
}
