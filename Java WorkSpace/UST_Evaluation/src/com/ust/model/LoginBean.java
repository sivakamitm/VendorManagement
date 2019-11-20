package com.ust.model;

public class LoginBean {

	//login table fields
	private int userId;
	private String userName;
	private String password;
	
	//default constructor of the class
	public LoginBean() {
		super();
	}

	//parameterized constructor of the class
	public LoginBean(int userId, String userName, String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
	}

	//getters and setters of the class
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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
	
	//overrided toString method of the class
	@Override
	public String toString() {
		return "Login [userId=" + userId + ", userName=" + userName
				+ ", password=" + password + "]";
	}
	
	
}
