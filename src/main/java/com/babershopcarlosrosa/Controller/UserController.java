package com.babershopcarlosrosa.Controller;

import com.babershopcarlosrosa.model.dto.AuthenticateRequestDTO;
import com.babershopcarlosrosa.model.dto.CustomerDTO;
import com.babershopcarlosrosa.service.AuthenticateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/barbershop")
public class UserController {

    @Autowired
    private AuthenticateService authenticateService;

    @PostMapping(value = "/login", consumes = "application/json")
    public ResponseEntity<String> login(@RequestBody AuthenticateRequestDTO request) {

        boolean isAuthenticated = authenticateService.authenticate(request);

        if (isAuthenticated) {
            return ResponseEntity.status(HttpStatus.OK).body("User authenticated");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }
    
    @PostMapping(value = "/register", consumes = "application/json")
    public ResponseEntity<String> register(@RequestBody CustomerDTO customerDTO) {
        return ResponseEntity.status(HttpStatus.OK).body("User created");
    }

}
