package com.babershopcarlosrosa.repository;

import com.babershopcarlosrosa.model.dto.AuthenticateRequestDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    
    private final JdbcTemplate jdbcTemplate = new JdbcTemplate();

    public boolean getUserAuthenticate(AuthenticateRequestDTO login) {
    	String username = null;
        jdbcTemplate.query("SELECT * FROM barbershop.TB_USER", r -> {
        	System.out.println(r.getString(0));
        });
        return true;
    }

}
