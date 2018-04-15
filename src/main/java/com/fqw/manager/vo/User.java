package com.fqw.manager.vo;

public class User {

	private String userName;
	private String password;
	private String authority;
	
	public User() {
		super();
	}

	public User(String userName, String password, String authority) {
		super();
		this.userName = userName;
		this.password = password;
		this.authority = authority;
	}

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

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", authority=" + authority + "]";
	}
	
	
}
