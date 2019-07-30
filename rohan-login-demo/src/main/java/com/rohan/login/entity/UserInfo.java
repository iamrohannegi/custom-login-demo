package com.rohan.login.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//Stores new user-information from Registration form
public class UserInfo {
	
	@NotNull(message= " is required")
	@Size(min=1, message=" is required")
	@Size(max=50, message=" can't be greater than 50 characters.")
	private String userName;
		
	@NotNull(message= " is required")
	@Size(min=1, message=" is required")
	@Size(max=68, message=" can't be greater than 60 characters.")
	private String password;
	
	@NotNull(message= " is required")
	@Size(min=1, message= " is required")
	private String role;
	
	public UserInfo() {}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
