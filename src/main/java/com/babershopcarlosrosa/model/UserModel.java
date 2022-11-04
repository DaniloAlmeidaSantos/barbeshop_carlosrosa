package com.babershopcarlosrosa.model;

import lombok.ToString;

@ToString
public abstract class UserModel {

	private String name;
	private String password;
	private String email;
	private String userType;


	public UserModel() {

	}

	public UserModel(String name, String userType, String email, String password) {
		this.name = name;
		this.userType = userType;
		this.email = email;
		this.password = password;
	}

	public abstract boolean actions();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
