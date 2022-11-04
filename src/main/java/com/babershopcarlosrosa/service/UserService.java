package com.babershopcarlosrosa.service;

import java.util.List;

import com.babershopcarlosrosa.model.UserModel;
import com.babershopcarlosrosa.model.dto.ServiceDTO;

public interface UserService {
	
	void toSchedule(String date, List<ServiceDTO> services);
	void settings(UserModel userParams);
	
}
