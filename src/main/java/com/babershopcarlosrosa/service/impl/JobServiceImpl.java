package com.babershopcarlosrosa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.babershopcarlosrosa.model.dto.JobDTO;
import com.babershopcarlosrosa.repository.JobRepository;
import com.babershopcarlosrosa.service.JobService;

@Component
public class JobServiceImpl implements JobService {
	
	@Autowired
	private JobRepository jobRepository;
	
	public boolean insertJob(JobDTO requestJob) {
		return jobRepository.insertJob(requestJob);
	}
	
	public boolean updateJob(JobDTO requestJob) {
		return jobRepository.updateJob(requestJob);
	}
	
	public List<JobDTO> getJob() {
		return jobRepository.getJobs();
	}
}
