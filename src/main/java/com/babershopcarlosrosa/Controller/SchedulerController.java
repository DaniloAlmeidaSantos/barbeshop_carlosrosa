package com.babershopcarlosrosa.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.babershopcarlosrosa.model.dto.ApiResponseDTO;
import com.babershopcarlosrosa.model.dto.ScheduleDTO;
import com.babershopcarlosrosa.service.ScheduleService;

@RestController
@RequestMapping("/barbershop")
public class SchedulerController {
	
	@Autowired
	private ScheduleService scheduleService;
	
	@GetMapping(value = "/schedule", produces = "application/json")
	public ResponseEntity<List<ScheduleDTO>> getSchedule() {
		return ResponseEntity.ok(null);
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
