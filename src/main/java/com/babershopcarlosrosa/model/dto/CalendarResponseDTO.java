package com.babershopcarlosrosa.model.dto;

import java.util.List;

import lombok.ToString;

@ToString
public class CalendarResponseDTO {

	private String date;
	private List<String> hoursAvailables;

	public CalendarResponseDTO() {
		// Empty constructor
	}

	public CalendarResponseDTO(String date, List<String> hoursAvailables) {
		this.date = date;
		this.hoursAvailables = hoursAvailables;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<String> getHoursAvailables() {
		return hoursAvailables;
	}

	public void setHoursAvailables(List<String> hoursAvailables) {
		this.hoursAvailables = hoursAvailables;
	}

}
