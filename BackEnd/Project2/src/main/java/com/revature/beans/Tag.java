package com.revature.beans;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "TAG")
@JsonInclude(Include.NON_ABSENT)
public class Tag implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2626576784350705568L;
	@Id
	@SequenceGenerator(name = "NEW_TAG_SEQ", sequenceName = "NEW_TAG_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NEW_TAG_SEQ")
	@Column(name = "TAG_ID")
	@JsonInclude(Include.NON_NULL)
	private int tagId;
	@Column(name = "TAG_NAME")
	@JsonInclude(Include.NON_NULL)
	private String tagName;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "tags")
	private Set<Page> pages = new HashSet<>();

	public Tag() {
		super();
	}

	public Tag(int tagId, String tagName) {
		super();
		this.tagId = tagId;
		this.tagName = tagName;
	}

	public int getTagId() {
		return tagId;
	}

	public void setTagId(int tagId) {
		this.tagId = tagId;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	@Override
	@JsonProperty(access = Access.WRITE_ONLY)
	public String toString() {
		return "Tag [tagId=" + tagId + ", tagName=" + tagName + "]";
	}

}
