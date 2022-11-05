package com.babershopcarlosrosa.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.babershopcarlosrosa.model.dto.CalendarResponseDTO;
import com.babershopcarlosrosa.model.dto.ParameterDTO;
import com.babershopcarlosrosa.repository.ParameterRepository;
import com.babershopcarlosrosa.service.CalendarService;

@Component
public class CalendarServiceImpl implements CalendarService {

	@Autowired
	private ParameterRepository parameterRepository;
	
	public CalendarResponseDTO showCalendar(String date) {
		ParameterDTO parameters = parameterRepository.getParameters();

		boolean isValidDayOfWeek = this.isValidDay(date, parameters);
		
		if (isValidDayOfWeek) {
			
			CalendarResponseDTO response = new CalendarResponseDTO();
			response.setDate(date);
			
			List<String> hours = new ArrayList<>();
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat formatHour = new SimpleDateFormat("HH:mm:ss");
			
			try {
				Date hourInit = formatHour.parse(parameters.getHourInitWork());
				Date hourEnd = formatHour.parse(parameters.getHourEndWork());
				int count = 0;
				
				while (hourInit.getTime() < hourEnd.getTime()) {
					calendar.setTime(hourInit);
					
					if (count > 0) {						
						calendar.add(Calendar.HOUR, 1);
					}
					
					hourInit = calendar.getTime();
					hours.add(String.valueOf(calendar.get(Calendar.HOUR_OF_DAY)) + ":00");
					count++;
				}
				
				response.setHoursAvailables(hours);
				
				return response;
			} catch (ParseException e) {
				e.printStackTrace();
			} 
			
		}
		
		return null;
	}

	private boolean isValidDay(String date, ParameterDTO parameters) {
		try {
			if (parameters.getDaysWork() != null) {
				String[] daysToWork = parameters.getDaysWork().split(",");
				
				// Calendar settings for get day of week
				Calendar calendar = Calendar.getInstance();
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");						
				Date dateRequest = dateFormat.parse(date);
				calendar.setTime(dateRequest);
				String dayOfWeek = String.valueOf(calendar.get(Calendar.DAY_OF_WEEK));
				
				for (String day : daysToWork) {
					if (dayOfWeek.equals(day)) {
						return true;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
}
