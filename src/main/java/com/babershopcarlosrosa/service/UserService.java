package com.babershopcarlosrosa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.babershopcarlosrosa.model.UserModel;
import com.babershopcarlosrosa.model.dto.ServiceDTO;

@Service
public interface UserService {
	void toSchedule(String date, List<ServiceDTO> services);
	void settings(UserModel userParams);
}
