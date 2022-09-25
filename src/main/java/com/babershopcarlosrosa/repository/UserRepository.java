package com.babershopcarlosrosa.repository;

import com.babershopcarlosrosa.model.dto.AuthenticateRequestDTO;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    public boolean getUserAuthenticate(AuthenticateRequestDTO login) {
        return true;
    }

}
