package com.babershopcarlosrosa.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.babershopcarlosrosa.model.UserModel;
import com.babershopcarlosrosa.model.dto.ApiResponseDTO;
import com.babershopcarlosrosa.service.UserService;

@RestController
@RequestMapping("/barbershop")
public class AdministratorController {
	
	@Autowired
	@Qualifier("AdministratorService")
	private UserService userService;
	
	
	@PostMapping(value = "/administrator/register", consumes = "application/json", produces = "application/json")
	public ResponseEntity<ApiResponseDTO> register(@RequestBody UserModel request) {
		boolean isRegistered = userService.register(request);

		if (isRegistered) {
			return ResponseEntity.status(HttpStatus.OK).body(new ApiResponseDTO("200", "User Created!"));
		}

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new ApiResponseDTO("500", "Error to create user!"));
	}

	@PutMapping(value = "/administrator/update", consumes = "application/json", produces = "application/json")
	public ResponseEntity<ApiResponseDTO> update(@RequestBody UserModel request, @RequestParam int userId) {
		boolean isUpdated = userService.updateUser(request, userId);

		if (isUpdated) {
			return ResponseEntity.status(HttpStatus.OK).body(new ApiResponseDTO("200", "User updated!"));
		}

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new ApiResponseDTO("500", "Error to update user!"));
	}
}
