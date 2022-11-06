package com.babershopcarlosrosa.model.dto;

public class ScheduleDTO {

	private int customerId;
	private int barberId;
	private String date;
	private String time;
	
	public ScheduleDTO(int customerId, int barberId, String date, String time) {
		this.customerId = customerId;
		this.barberId = barberId;
		this.date = date;
		this.time = time;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getBarberId() {
		return barberId;
	}

	public void setBarberId(int barberId) {
		this.barberId = barberId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
}
