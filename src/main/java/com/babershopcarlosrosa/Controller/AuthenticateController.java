package com.babershopcarlosrosa.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.babershopcarlosrosa.model.dto.AuthenticateRequestDTO;
import com.babershopcarlosrosa.model.dto.AuthenticateResponseDTO;
import com.babershopcarlosrosa.service.AuthenticateService;

@RestController
@RequestMapping("/barbershop")
public class AuthenticateController {
	
	@Autowired
	private AuthenticateService authenticateService;
	
	@PostMapping(value = "/user/login", consumes = "application/json", produces = "application/json")
	public ResponseEntity<AuthenticateResponseDTO> login(@RequestBody AuthenticateRequestDTO request) {

		AuthenticateResponseDTO response = authenticateService.authenticate(request);

		if (response != null) {
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new AuthenticateResponseDTO());
	}
}
