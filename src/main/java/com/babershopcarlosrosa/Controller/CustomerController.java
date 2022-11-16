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

import com.babershopcarlosrosa.model.dto.ApiResponseDTO;
import com.babershopcarlosrosa.model.dto.CustomerDTO;
import com.babershopcarlosrosa.service.UserService;

@RestController
@RequestMapping("/barbershop")
public class CustomerController {

	@Autowired
	@Qualifier("CustomerService")
	private UserService userService;

	@PostMapping(value = "/user/register", consumes = "application/json", produces = "application/json")
	public ResponseEntity<ApiResponseDTO> register(@RequestBody CustomerDTO customerDTO) {
		boolean isRegistered = userService.register(customerDTO);

		if (isRegistered) {
			return ResponseEntity.status(HttpStatus.OK).body(new ApiResponseDTO("200", "User Created!"));
		}

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new ApiResponseDTO("500", "Error to create user!"));
	}

	@PutMapping(value = "/user/update", consumes = "application/json", produces = "application/json")
	public ResponseEntity<ApiResponseDTO> update(@RequestBody CustomerDTO request, @RequestParam int userId) {
		boolean isUpdated = userService.updateUser(request, userId);

		if (isUpdated) {
			return ResponseEntity.status(HttpStatus.OK).body(new ApiResponseDTO("200", "User updated!"));
		}

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new ApiResponseDTO("500", "Error to update user!"));
	}

}
