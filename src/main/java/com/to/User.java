package com.to;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table
@SequenceGenerator(name = "seq",initialValue = 123456,allocationSize = 100000)
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq")
	private int userID;
	@NotEmpty(message = "username cannot be empty")
	@Length(max = 20)
	private String username;
	@NotEmpty(message = "password cannot be empty")
	@Length(max = 20)
	private String password;
	
	public User() {
		
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUsername() {
		return username;
	}

	public User(int userID) {
		super();
		this.userID = userID;
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

	@Override
	public String toString() {
		return "User [userID=" + userID + ", username=" + username + ", password=" + password + "]";
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
}
