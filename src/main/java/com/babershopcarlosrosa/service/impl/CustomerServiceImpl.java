package com.babershopcarlosrosa.service.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.babershopcarlosrosa.model.UserModel;
import com.babershopcarlosrosa.model.dto.CustomerDTO;
import com.babershopcarlosrosa.model.dto.ServiceDTO;
import com.babershopcarlosrosa.repository.RegisterUserRepository;
import com.babershopcarlosrosa.service.RegisterService;
import com.babershopcarlosrosa.service.UserService;

@Component
public class CustomerServiceImpl implements UserService, RegisterService {
	
	@Autowired
	private RegisterUserRepository userRepository;
	
	@Override
	public void toSchedule(String date, List<ServiceDTO> services) {
	}

	@Override
	public void settings(UserModel userParams) {
	}

	@Override
	public boolean register(CustomerDTO customer) {
		try {
			return userRepository.register(customer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
