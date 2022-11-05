package com.babershopcarlosrosa.service;

import org.springframework.stereotype.Service;

import com.babershopcarlosrosa.model.dto.JobDTO;

@Service
public interface JobService {
	
	boolean createJob (JobDTO requestJob);
	
	
}
