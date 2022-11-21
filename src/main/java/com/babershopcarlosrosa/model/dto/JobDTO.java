package com.babershopcarlosrosa.model.dto;

import lombok.ToString;

@ToString
public class JobDTO {

	private int jobId;
	private int jobPrice;
	private String jobName;

	public JobDTO() {
		// Empty Constructor
	}

	public JobDTO(int jobId, int jobPrice, String jobName) {
		this.jobId = jobId;
		this.jobPrice = jobPrice;
		this.jobName = jobName;
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public int getJobPrice() {
		return jobPrice;
	}

	public void setJobPrice(int jobPrice) {
		this.jobPrice = jobPrice;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

}
