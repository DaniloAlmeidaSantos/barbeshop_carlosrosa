package com.babershopcarlosrosa.model.dto;

public class AuthenticateResponseDTO {
	private long userId;
	private String typeUser;
	
	public AuthenticateResponseDTO() {
		// Empty constructor
	}

	public AuthenticateResponseDTO(long userId, String typeUser) {
		this.userId = userId;
		this.typeUser = typeUser;
	}
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getTypeUser() {
		return typeUser;
	}
	public void setTypeUser(String typeUser) {
		this.typeUser = typeUser;
	}
	
	
}
