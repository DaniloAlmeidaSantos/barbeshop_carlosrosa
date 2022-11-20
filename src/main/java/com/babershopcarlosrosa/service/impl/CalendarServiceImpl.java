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
import com.babershopcarlosrosa.model.dto.ScheduleDTO;
import com.babershopcarlosrosa.repository.ParameterRepository;
import com.babershopcarlosrosa.repository.ScheduleRepository;
import com.babershopcarlosrosa.service.CalendarService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CalendarServiceImpl implements CalendarService {

	@Autowired
	private ParameterRepository parameterRepository;

	@Autowired
	private ScheduleRepository scheduleRepository;

	public CalendarResponseDTO showCalendar(String date) {
		
		log.info("[ PROCCESS - CALENDAR ] Getting diponible calendar");
		ParameterDTO parameters = parameterRepository.getParameters();

		boolean isValidDayOfWeek = this.isValidDay(date, parameters);

		if (isValidDayOfWeek) {
			CalendarResponseDTO response = getHoursDisponible(parameters, date);
			log.info("[ OUT - CALENDAR ] Get calendar successfully: {} ", response.toString());
			return response;
		}

		return null;

	}

	private CalendarResponseDTO getHoursDisponible(ParameterDTO parameters, String date) {
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
				String hourDisponible = String.valueOf(calendar.get(Calendar.HOUR_OF_DAY)) + ":00";
				if (!scheduleRepository.searchByDateTime(new ScheduleDTO(0, 0, "", date, hourDisponible))) {
					hours.add(hourDisponible);
				}
				count++;
			}

			response.setHoursAvailables(hours);

			return response;
		} catch (ParseException e) {
			log.error("[ OUT - CALENDAR ] Error to parse dates: {} ", e);
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
			log.error("[ OUT - CALENDAR ] Error to validate day: {} ", e);
		}

		return false;
	}
}
