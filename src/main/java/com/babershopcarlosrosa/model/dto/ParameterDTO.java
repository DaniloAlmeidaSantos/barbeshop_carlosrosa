package com.babershopcarlosrosa.model.dto;

public class ParameterDTO {
	private String daysWork;
	private String hourInitWork;
	private String hourEndWork;
	private String namePlace;

	public ParameterDTO(String daysWork, String hourInitWork, String hourEndWork, String namePlace) {
		this.daysWork = daysWork;
		this.hourInitWork = hourInitWork;
		this.hourEndWork = hourEndWork;
		this.namePlace = namePlace;
	}

	public String getDaysWork() {
		return daysWork;
	}

	public void setDaysWork(String daysWork) {
		this.daysWork = daysWork;
	}

	public String getHourInitWork() {
		return hourInitWork;
	}

	public void setHourInitWork(String hourInitWork) {
		this.hourInitWork = hourInitWork;
	}

	public String getHourEndWork() {
		return hourEndWork;
	}

	public void setHourEndWork(String hourEndWork) {
		this.hourEndWork = hourEndWork;
	}

	public String getNamePlace() {
		return namePlace;
	}

	public void setNamePlace(String namePlace) {
		this.namePlace = namePlace;
	}
}
