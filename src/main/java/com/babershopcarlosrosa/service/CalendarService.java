package com.babershopcarlosrosa.service;

import org.springframework.stereotype.Service;

import com.babershopcarlosrosa.model.dto.CalendarResponseDTO;

@Service
public interface CalendarService {
	CalendarResponseDTO showCalendar(String date);
}
