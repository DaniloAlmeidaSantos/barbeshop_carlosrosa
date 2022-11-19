package com.babershopcarlosrosa.service;


import org.springframework.stereotype.Service;

import com.babershopcarlosrosa.model.dto.ParameterDTO;

@Service
public interface ParameterService {
	boolean parameter(ParameterDTO workParametersDTO);
	ParameterDTO getParameters();
}
