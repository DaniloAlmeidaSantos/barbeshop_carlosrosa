package com.babershopcarlosrosa.model.dto;

import java.util.List;

public class ScheduledDTO {

	private long id;
	private String date;
	private String time;
	private String barber;
	private List<JobDTO> services;

	public ScheduledDTO() {
		// Empty constructor
	}

	public ScheduledDTO(long id, String date, String time, String barber, List<JobDTO> services) {
		this.id = id;
		this.date = date;
		this.time = time;
		this.barber = barber;
		this.services = services;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getBarber() {
		return barber;
	}

	public void setBarber(String barber) {
		this.barber = barber;
	}

	public List<JobDTO> getServices() {
		return services;
	}

	public void setServices(List<JobDTO> services) {
		this.services = services;
	}

	@Override
	public String toString() {
		return "ScheduledDTO [id=" + id + ", date=" + date + ", time=" + time + ", barber=" + barber + ", services="
				+ services + "]";
	}

}
