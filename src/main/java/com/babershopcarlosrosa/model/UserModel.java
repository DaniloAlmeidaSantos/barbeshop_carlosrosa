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
	private String lastName;
	private String email;
	
	public UserModel() {
		
	}

	public UserModel(String name, String lastName, String email) {
		this.name = name;
		this.lastName = lastName;
		this.email = email;
	}
	
	public abstract boolean actions();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
