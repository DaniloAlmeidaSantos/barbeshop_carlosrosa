package com.babershopcarlosrosa.model.dto;

public class BarberDTO {

	private long id;
	private String name;

	public BarberDTO() {
		// Empty constructor
	}

	public BarberDTO(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
