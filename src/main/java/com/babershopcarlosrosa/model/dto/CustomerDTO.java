package com.babershopcarlosrosa.model.dto;

import com.babershopcarlosrosa.model.UserModel;

public class CustomerDTO extends UserModel {
	private String cpf;

	public CustomerDTO() {
	}

	public CustomerDTO(String name, String userType, String email, String phone, String cpf, String password) {
		super(name, userType, email, password, phone);
		this.cpf = cpf;
	}
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	@Override
	public String toString() {
		return "CustomerDTO [cpf=" + cpf + ", UserMode[" + super.toString() + "] ]";
	}

}
