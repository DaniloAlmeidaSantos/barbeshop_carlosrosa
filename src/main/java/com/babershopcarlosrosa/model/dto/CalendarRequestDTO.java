package com.babershopcarlosrosa.model.dto;

import java.io.Serializable;

public class CalendarRequestDTO implements Serializable {

	private static final long serialVersionUID = 8485951138362699243L;
	
	private String date;

	public CalendarRequestDTO(String date) {
		this.date = date;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
