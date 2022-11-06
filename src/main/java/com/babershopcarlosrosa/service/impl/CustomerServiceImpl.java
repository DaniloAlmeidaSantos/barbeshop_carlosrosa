package com.babershopcarlosrosa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.babershopcarlosrosa.model.dto.CustomerDTO;
import com.babershopcarlosrosa.repository.UserRepository;
import com.babershopcarlosrosa.service.UserService;

@Component
public class CustomerServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	public boolean register(CustomerDTO customer) {
		try {
			return userRepository.register(customer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean updateUser(CustomerDTO request, int id) { 
		return userRepository.updateUser(request, id);
	}
	
}
