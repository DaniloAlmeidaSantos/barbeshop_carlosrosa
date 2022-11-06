package com.babershopcarlosrosa.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.babershopcarlosrosa.model.dto.ApiResponseDTO;
import com.babershopcarlosrosa.model.dto.AuthenticateRequestDTO;
import com.babershopcarlosrosa.model.dto.CustomerDTO;
import com.babershopcarlosrosa.service.AuthenticateService;
import com.babershopcarlosrosa.service.RegisterService;

@RestController
@RequestMapping("/barbershop")
public class UserController {

    @Autowired
    private AuthenticateService authenticateService;
    
    @Autowired
    private RegisterService registerService;

    @PostMapping(value = "/login", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ApiResponseDTO> login(@RequestBody AuthenticateRequestDTO request) {
    	
        boolean isAuthenticated = authenticateService.authenticate(request);

        if (isAuthenticated) {
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponseDTO("200", "User authenticated!"));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponseDTO("404", "User not found!"));
    }
    
    @PostMapping(value = "/register", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ApiResponseDTO> register(@RequestBody CustomerDTO customerDTO) {
    	
    	boolean isRegistered = registerService.register(customerDTO);
    	
    	if (isRegistered) {    		
    		return ResponseEntity.status(HttpStatus.OK).body(new ApiResponseDTO("200", "User Created!"));
    	}
    	
    	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponseDTO("500", "Error to create user!"));
    }

}
