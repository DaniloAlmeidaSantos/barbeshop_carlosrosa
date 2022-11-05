package com.babershopcarlosrosa.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.babershopcarlosrosa.model.dto.ScheduleDTO;

@RestController
@RequestMapping("/barbershop")
public class SchedulerController {
	
	@GetMapping(value = "/schedule", produces = "application/json")
	public ResponseEntity<ScheduleDTO> getSchedule() {
		
	}
	
}
