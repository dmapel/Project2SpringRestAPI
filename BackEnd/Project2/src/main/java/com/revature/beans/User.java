package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "USERS")
public class User {

	@Id
	@SequenceGenerator(name = "NEW_USER_SEQ", sequenceName = "NEW_USER_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NEW_USER_SEQ")
	@Column(name = "U_ID")
	private int uId;

	@Column(name = "F_NAME")
	private String fName;

	@Column(name = "L_NAME")
	private String lName;

	@Column(name = "USERNAME")
	private String username;


	@Column(name = "PASSWORD")
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;

	@Column(name = "POS_ID")
	private int posId = 1;
	

	public User() {
		super();
	}

	

	public User(int uId, String fName, String lName, String username, String password, int posId) {
		super();
		this.uId = uId;
		this.fName = fName;
		this.lName = lName;
		this.username = username;
		this.password = password;
		this.posId = posId;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPosId() {
		return posId;
	}

	public void setPosId(int posId) {
		this.posId = posId;
	}

	@Override
	public String toString() {
		return "User [uId=" + uId + ", fName=" + fName + ", lName=" + lName + ", username=" + username + ", password="
				+ password + ", posId=" + posId + "]";
	}
}
