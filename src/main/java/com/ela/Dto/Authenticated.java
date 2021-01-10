package com.ela.Dto;

import org.springframework.stereotype.Component;

@Component
public class Authenticated {
	private String token;
	private int userID;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	

}
