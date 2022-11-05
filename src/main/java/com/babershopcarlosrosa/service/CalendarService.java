package com.babershopcarlosrosa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.babershopcarlosrosa.model.dto.ScheduleDTO;

@Service
public interface CalendarService {
	List<ScheduleDTO> showCalendar();
}
