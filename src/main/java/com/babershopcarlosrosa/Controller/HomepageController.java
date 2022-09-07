package com.babershopcarlosrosa.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/barbershop/homepage")
public class HomepageController {

    @GetMapping
    public ResponseEntity<String> permissionsRoutines() {
        return ResponseEntity.ok("Hello World");
    }

}
