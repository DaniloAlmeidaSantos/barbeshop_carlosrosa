package com.babershopcarlosrosa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.babershopcarlosrosa.model.UserModel;
import com.babershopcarlosrosa.model.dto.CustomerDTO;
import com.babershopcarlosrosa.repository.UserRepository;
import com.babershopcarlosrosa.service.UserService;

@Component
@Qualifier("CustomerService")
public class CustomerServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	public boolean register(UserModel customer) {
		try {
			CustomerDTO customerDTO = (CustomerDTO) customer;
			return userRepository.register(customerDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean updateUser(UserModel request, int id) { 
		CustomerDTO customerDTO = (CustomerDTO) request;
		return userRepository.updateUser(customerDTO, id);
	}
	
}
