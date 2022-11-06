package com.babershopcarlosrosa.service;

import org.springframework.stereotype.Service;

import com.babershopcarlosrosa.model.dto.CustomerDTO;

@Service
public interface UserService {
	boolean register(CustomerDTO customer);
	boolean updateUser(CustomerDTO customer, int id);
}
