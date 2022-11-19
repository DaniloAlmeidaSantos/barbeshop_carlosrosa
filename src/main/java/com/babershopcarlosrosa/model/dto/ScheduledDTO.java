package com.babershopcarlosrosa.model.dto;

public class ScheduledDTO {

	private String indentifications;
	private String date;
	private String time;
	private String jobIndentification;
	private String jobs;
	private String status;
	private double totalPrice;

	public ScheduledDTO() {
		// Empty constructor
	}

	public ScheduledDTO(String indentifications, String date, String time, String jobIndentification, String jobs,
			String status, double totalPrice) {
		this.indentifications = indentifications;
		this.date = date;
		this.time = time;
		this.jobIndentification = jobIndentification;
		this.jobs = jobs;
		this.status = status;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

}
