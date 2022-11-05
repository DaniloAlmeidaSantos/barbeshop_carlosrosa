package com.babershopcarlosrosa.model.dto;

import java.sql.Date;

public class CalendarDTO {

	private Date dateTime;
	private String status;

	public CalendarDTO(Date dateTime, String status) {
		this.dateTime = dateTime;
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	
}
