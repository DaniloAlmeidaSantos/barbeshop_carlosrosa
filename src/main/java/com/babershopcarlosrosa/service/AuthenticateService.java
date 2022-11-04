package com.babershopcarlosrosa.service;

import com.babershopcarlosrosa.model.dto.AuthenticateRequestDTO;
import org.springframework.stereotype.Service;

@Service
public interface AuthenticateService {
    boolean authenticate(AuthenticateRequestDTO request);
}
