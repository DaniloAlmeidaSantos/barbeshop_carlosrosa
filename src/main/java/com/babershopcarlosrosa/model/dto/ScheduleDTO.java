package com.babershopcarlosrosa.model.dto;

import lombok.ToString;

@ToString
public class ScheduleDTO {

	private int customerId;
	private int barberId;
	private String servicesId;
	private String date;
	private String time;

	public ScheduleDTO() {
		// Empty Constructor
	}

	public ScheduleDTO(int customerId, int barberId, String servicesId, String date, String time) {
		this.customerId = customerId;
		this.barberId = barberId;
		this.servicesId = servicesId;
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

	public String getServicesId() {
		return servicesId;
	}

	public void setServicesId(String servicesId) {
		this.servicesId = servicesId;
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
