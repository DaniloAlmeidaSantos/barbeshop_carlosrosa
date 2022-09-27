package com.babershopcarlosrosa.models;

import java.util.Date;

public class ServiceHair {
	
	private int id;
	private String nameService;
	private double price;
	private Date dateSchedule;
	
	public ServiceHair() { }
	
	public ServiceHair( int id, String nameService, double price, Date dateSchedule) {
		this.setId(id);
		this.setNameService(nameService);
		this.setPrice(price);
		this.setDateSchedule(dateSchedule);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameService() {
		return nameService;
	}

	public void setNameService(String nameService) {
		this.nameService = nameService;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getDateSchedule() {
		return dateSchedule;
	}

	public void setDateSchedule(Date dateSchedule) {
		this.dateSchedule = dateSchedule;
	}

	// Polimorfism --> Exigido para POO
	@Override
	public String toString() {
		return "id= " + this.getId() + ", nameService= " + this.getNameService() +
				", price= " + this.getPrice() + ", dateSchedule= " + this.getDateSchedule();
	}
	
	
	
}
