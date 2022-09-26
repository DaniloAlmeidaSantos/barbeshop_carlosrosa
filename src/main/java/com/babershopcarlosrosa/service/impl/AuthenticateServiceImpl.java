package com.babershopcarlosrosa.service.impl;

import com.babershopcarlosrosa.model.dto.AuthenticateRequestDTO;
import com.babershopcarlosrosa.repository.UserRepository;
import com.babershopcarlosrosa.service.AuthenticateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthenticateServiceImpl implements AuthenticateService {

    @Autowired
    private UserRepository userRepository;

    public boolean login(AuthenticateRequestDTO request) {

        if (request.getEmail() != null && request.getPassword() != null) {

            return userRepository.getUserAuthenticate(request);

        }

        return false;
    }
}
