package com.babershopcarlosrosa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.babershopcarlosrosa.model.UserModel;
import com.babershopcarlosrosa.model.dto.CustomerDTO;
import com.babershopcarlosrosa.repository.UserRepository;
import com.babershopcarlosrosa.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Qualifier("AdministratorService")
public class AdministratorServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
	
    public boolean register(UserModel admin) {
		try {
			log.info("[ INPUT - ADMINISTRATOR ] Registering user");
			admin.setUserType("A");
			return userRepository.registerAdministrator(admin);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("[ OUT - ADMINISTRATOR ] Error to register user: {} ", e);
		}
		
		return false;
	}
	
	public boolean updateUser(UserModel request, int id) { 
		log.info("[ INPUT - ADMINISTRATOR ] Updating user");
		CustomerDTO customerDTO = (CustomerDTO) request;
		return userRepository.updateUser(customerDTO, id);
	}
	
	public boolean isAdministrator(long userId) {
		return userRepository.isAdministrator(userId);
	}

}
