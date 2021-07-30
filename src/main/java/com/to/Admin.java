package com.to;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int adminID;
	@NotEmpty(message = "adminname cannot be empty")
	private String adminname;
	@NotEmpty(message = "password cannot be empty")
	private String password;
	
	public Admin() {
		
	}

	public int getAdminID() {
		return adminID;
	}



	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}



	public String getAdminname() {
		return adminname;
	}

	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [adminID=" + adminID + ", adminname=" + adminname + ", password=" + password + "]";
	}



	public Admin(String adminname, String password) {
		super();
		this.adminname = adminname;
		this.password = password;
	}
	
}
