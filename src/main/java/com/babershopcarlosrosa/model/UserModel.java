package com.babershopcarlosrosa.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public abstract class UserModel {

	private String name;
	private String password;
	private String email;
	private char userType;


	public UserModel() {

	}

	public UserModel(String name, char userType, String email, String password) {
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

	public char getUserType() {
		return userType;
	}

	public void setUserType(char userType) {
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
