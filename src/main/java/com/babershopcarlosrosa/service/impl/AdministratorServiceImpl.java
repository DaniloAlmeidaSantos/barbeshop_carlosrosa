package com.babershopcarlosrosa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.babershopcarlosrosa.model.UserModel;
import com.babershopcarlosrosa.repository.UserRepository;
import com.babershopcarlosrosa.service.UserService;

@Component
@Qualifier("AdministratorService")
public class AdministratorServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;
	
	@Override
	public boolean register(UserModel customer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUser(UserModel customer, int id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean isAdministrator(long userId) {
		return userRepository.isAdministrator(userId);
	}

}
