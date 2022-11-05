package com.babershopcarlosrosa.model.dto;

import java.sql.Date;

public class ScheduleDTO {

	private int customerId;
	private int barberId;
	private Date date;
	private Date time;

	public int getBarberId() {
		return barberId;
	}
	
	public void setBarberId(int barberId) {
		this.barberId = barberId;
	}
	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public ScheduleDTO(Date date, Date time) {
		this.date = date;
		this.time = time;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
