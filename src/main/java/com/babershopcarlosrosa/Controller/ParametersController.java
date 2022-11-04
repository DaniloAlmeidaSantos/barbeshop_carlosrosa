package com.babershopcarlosrosa.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.babershopcarlosrosa.service.ParametersService;

@RestController
@RequestMapping("/barbershop")
public class ParametersController {
    
    @Autowired
    private ParametersService parametersService;

    @GetMapping("/parameters")
    public ResponseEntity<String> getParameters() {
        return parametersService.searchByTime();
    }

}
