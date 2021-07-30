package com.to;

public class AdminMod {
	private int userId;
	
	public AdminMod() {
		
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public AdminMod(int userId) {
		super();
		this.userId = userId;
	}
}