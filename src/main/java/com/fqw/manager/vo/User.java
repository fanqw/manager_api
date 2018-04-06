package com.fqw.manager.vo;

public class User {

	private String userName;
	private String password;
	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	public String getUsername() {
		return userName;
	}
	public void setUsername(String username) {
		this.userName = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [username=" + userName + ", password=" + password + "]";
	}
	
	
}
