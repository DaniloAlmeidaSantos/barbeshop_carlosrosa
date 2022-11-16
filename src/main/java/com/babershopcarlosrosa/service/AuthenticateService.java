package com.babershopcarlosrosa.service;

import com.babershopcarlosrosa.model.dto.AuthenticateRequestDTO;
import com.babershopcarlosrosa.model.dto.AuthenticateResponseDTO;

import org.springframework.stereotype.Service;

@Service
public interface AuthenticateService {
    AuthenticateResponseDTO authenticate(AuthenticateRequestDTO request);
}
