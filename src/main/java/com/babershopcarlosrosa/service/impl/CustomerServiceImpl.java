package com.babershopcarlosrosa.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.babershopcarlosrosa.model.UserModel;
import com.babershopcarlosrosa.model.dto.CustomerDTO;
import com.babershopcarlosrosa.model.dto.ServiceDTO;
import com.babershopcarlosrosa.service.RegisterService;
import com.babershopcarlosrosa.service.UserService;

@Component
public class CustomerServiceImpl implements UserService, RegisterService {

	@Override
	public void toSchedule(String date, List<ServiceDTO> services) {
	}

	@Override
	public void settings(UserModel userParams) {
	}

	@Override
	public boolean register(CustomerDTO customer) {
		return false;
	}
}
