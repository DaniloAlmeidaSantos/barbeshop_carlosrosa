package com.babershopcarlosrosa.models;

import java.util.Date;

public class User {

	private int id;
	private String nameClient;
	private String email;
	private String password;
	private String phone;
	private char type; // Alinhar atributo
	private Date dateCreated;
	
	public User () { }
	
	public User (int Id, String nameClient, String email,
				 String password, String phone, Date dateCreated) {
		
		this.setId(Id);
		this.setNameClient(nameClient);
		this.setEmail(email);
		this.setPassword(password);
		this.setPhone(phone);
		this.setDateCreated(dateCreated);
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameClient() {
		return nameClient;
	}

	public void setNameClient(String nameClient) {
		this.nameClient = nameClient;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	// Polimorfism --> Exigido para POO
	@Override
	public String toString() {
		return "id= " + this.getId() + ", nameClient= " + this.getNameClient() +
				", email= " + this.getEmail() + ", password= " + this.getPassword() +
				", phone= " + this.getPhone() + ", dateCreated= " + this.getDateCreated();
	}

}
