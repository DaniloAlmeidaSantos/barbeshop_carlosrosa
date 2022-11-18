package com.babershopcarlosrosa.model;

import lombok.ToString;

@ToString
public abstract class UserModel {

	private String name;
	private String password;
	private String email;
	private String userType;
	private String phone;

	public UserModel() {
		// Empty constructor
	}
	
	public UserModel(String name, String password, String email, String userType, String phone) {
		this.name = name;
		this.password = password;
		this.email = email;
		this.userType = userType;
		this.phone = phone;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
