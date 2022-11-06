package com.babershopcarlosrosa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.babershopcarlosrosa.model.dto.JobDTO;

@Service
public interface JobService {
	
	boolean insertJob (JobDTO requestJob);
	boolean updateJob (JobDTO requestJob);
	List<JobDTO> getJob();
}
