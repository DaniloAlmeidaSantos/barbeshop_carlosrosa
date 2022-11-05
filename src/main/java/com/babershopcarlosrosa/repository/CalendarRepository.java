package com.babershopcarlosrosa.repository;

import java.util.List;

import com.babershopcarlosrosa.model.dto.CalendarDTO;
import com.babershopcarlosrosa.repository.config.ConnectionRepositoryConfig;

public class CalendarRepository extends ConnectionRepositoryConfig {
	
	public List<CalendarDTO> getCalendar() {
		try {
			super.getConnection();
					
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
	
}
