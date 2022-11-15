package com.babershopcarlosrosa.model.dto;

import com.babershopcarlosrosa.model.UserModel;

public class CustomerDTO extends UserModel {

	private String phone;
	private String cpf;

	public CustomerDTO() {
	}

	public CustomerDTO(String name, String userType, String email, String phone, String cpf, String password) {
		super(name, userType, email, password);
		this.phone = phone;
		this.cpf = cpf;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public boolean actions() {
		return false;
	}

	@Override
	public String toString() {
		return "CustomerDTO [phone=" + phone + ", cpf=" + cpf + "]";
	}

}
