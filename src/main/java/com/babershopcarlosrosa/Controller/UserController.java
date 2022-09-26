package com.babershopcarlosrosa.Controller;

import com.babershopcarlosrosa.model.dto.AuthenticateRequestDTO;
import com.babershopcarlosrosa.service.AuthenticateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/barbershop/homepage")
public class UserController {

    @Autowired
    private AuthenticateService authenticateService;

    @PostMapping(value = "/login", consumes = "application/json")
    public ResponseEntity<String> login(@RequestBody AuthenticateRequestDTO request) {

        boolean isAuthenticated = authenticateService.login(request);

        if (isAuthenticated) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User authenticated");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }

}
