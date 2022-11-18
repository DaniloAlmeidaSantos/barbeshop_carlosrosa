package com.babershopcarlosrosa.model.dto;

public class ScheduledDTO {

	private String indentifications;
	private String date;
	private String time;
	private String jobIndentification;
	private String jobs;
	private double totalPrice;

	public ScheduledDTO() {
		// Empty constructor
	}

	public ScheduledDTO(String indentifications, String date, String time, String jobIndentification,
			String jobs, double totalPrice) {
		this.indentifications = indentifications;
		this.date = date;
		this.time = time;
		this.jobIndentification = jobIndentification;
		this.jobs = jobs;
		this.totalPrice = totalPrice;
	}

	public String getIndentifications() {
		return indentifications;
	}

	public void setIndentifications(String indentifications) {
		this.indentifications = indentifications;
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

	public String getJobIndentification() {
		return jobIndentification;
	}

	public void setJobIndentification(String jobIndentification) {
		this.jobIndentification = jobIndentification;
	}

	public String getJobs() {
		return jobs;
	}

	public void setJobs(String jobs) {
		this.jobs = jobs;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
}
