package com.babershopcarlosrosa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.babershopcarlosrosa.model.dto.AuthenticateRequestDTO;
import com.babershopcarlosrosa.model.dto.AuthenticateResponseDTO;
import com.babershopcarlosrosa.repository.AuthenticateUserRepository;
import com.babershopcarlosrosa.service.AuthenticateService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AuthenticateServiceImpl implements AuthenticateService {

	@Autowired
    private AuthenticateUserRepository userRepository;

    public AuthenticateResponseDTO authenticate(AuthenticateRequestDTO request) {
    	log.info("[ INPUT - AUTHENTICATE ] Authenticating user, payload received: {} ", request);
        if (request.getEmail() != null && request.getPassword() != null) {
            return userRepository.authenticate(request);

        }

        return null;
    }
}
