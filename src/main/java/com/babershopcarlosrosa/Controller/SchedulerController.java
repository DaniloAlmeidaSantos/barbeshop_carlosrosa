package com.babershopcarlosrosa.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.babershopcarlosrosa.model.dto.ApiResponseDTO;
import com.babershopcarlosrosa.model.dto.CalendarResponseDTO;
import com.babershopcarlosrosa.model.dto.ScheduleDTO;
import com.babershopcarlosrosa.service.CalendarService;
import com.babershopcarlosrosa.service.ScheduleService;

@RestController
@RequestMapping("/barbershop")
public class SchedulerController {
	
	@Autowired
	private ScheduleService scheduleService;
	
	@Autowired
	private CalendarService calendarService;
	
	@GetMapping(value = "/schedule", produces = "application/json")
	public ResponseEntity<CalendarResponseDTO> getSchedule(@RequestParam String date) {
		
		CalendarResponseDTO response = calendarService.showCalendar(date);
		
		if (response != null) {
			return ResponseEntity.ok().body(response);
		}
		
		return ResponseEntity.badRequest().body(null);
	}
	
	@PostMapping(value = "/schedule", consumes = "application/json", produces = "application/json")
	public ResponseEntity<ApiResponseDTO> scheduleService(@RequestBody ScheduleDTO request) {
		
		boolean isScheduled = scheduleService.insertSchedule(request);
		
		if (isScheduled) {
			return ResponseEntity.ok().body(new ApiResponseDTO("200", "Service scheduled"));

		}
		
		return ResponseEntity.badRequest().body(new ApiResponseDTO("400", "Error to schedule service"));
		
	}
	
}
