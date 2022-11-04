package com.babershopcarlosrosa.model.dto;

import com.babershopcarlosrosa.model.UserModel;

public class AdministratorDTO extends UserModel{

    private String phone;

    public AdministratorDTO(String name, String userType, String email, String phone, String password) {
        super(name, userType, email, password);
        this.phone = phone;
    }

    public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

    @Override
	public boolean actions() {
		return false;
	}

}