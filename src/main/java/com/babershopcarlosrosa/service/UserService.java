package com.babershopcarlosrosa.service;

import org.springframework.stereotype.Service;

import com.babershopcarlosrosa.model.UserModel;

@Service
public interface UserService {
	boolean register(UserModel customer);
	boolean updateUser(UserModel customer, int id);
}
