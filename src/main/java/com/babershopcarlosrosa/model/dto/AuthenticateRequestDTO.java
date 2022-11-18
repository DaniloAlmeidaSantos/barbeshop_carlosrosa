package com.babershopcarlosrosa.model.dto;

import lombok.ToString;

@ToString
public class AuthenticateRequestDTO {

    private String email;
    private String password;

    public AuthenticateRequestDTO() {
        // Empty Constructor
    }

    public AuthenticateRequestDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
