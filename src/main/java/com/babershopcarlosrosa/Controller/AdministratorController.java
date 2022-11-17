package com.babershopcarlosrosa.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.babershopcarlosrosa.service.UserService;

@RestController
@RequestMapping("/barbershop")
public class AdministratorController {
	
	@Autowired
	@Qualifier("AdministratorService")
	private UserService userService;
	
}
