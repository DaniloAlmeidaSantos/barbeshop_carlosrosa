package com.babershopcarlosrosa.model.dto;

public class JobDTO {
	
	private int jobId;
	private int jobPrice;
	private String jobName;
	
	public JobDTO(int jobId, int jobPrice, String jobName) {
		super();
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