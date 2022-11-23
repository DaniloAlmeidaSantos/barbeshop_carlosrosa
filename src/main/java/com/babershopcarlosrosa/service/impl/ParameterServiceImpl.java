package com.babershopcarlosrosa.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.babershopcarlosrosa.model.dto.ParameterDTO;
import com.babershopcarlosrosa.repository.ParameterRepository;
import com.babershopcarlosrosa.service.ParameterService;

@Component
public class ParameterServiceImpl implements ParameterService {

	@Autowired
	private ParameterRepository parameterRepository;
	
	@Override
	public boolean parameter(ParameterDTO workParametersDTO) {
		try {
			SimpleDateFormat formatHour = new SimpleDateFormat("HH:mm:ss");						
			Date hourInit = formatHour.parse(workParametersDTO.getHourInitWork());
			Date hourEnd = formatHour.parse(workParametersDTO.getHourEndWork());
						
			if(hourInit.getTime() < hourEnd.getTime()) {
				return parameterRepository.verifyExistParameter(workParametersDTO);
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return false;
	}

	public ParameterDTO getParameters() {
		return parameterRepository.getParameters();
	}
}	
