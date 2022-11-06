package com.babershopcarlosrosa.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.babershopcarlosrosa.model.dto.CustomerDTO;
import com.babershopcarlosrosa.repository.config.ConnectionRepositoryConfig;

@Repository
public class RegisterUserRepository extends ConnectionRepositoryConfig{
	
	public boolean register(CustomerDTO customerDTO) {		
		try {
			Connection connection = super.getConnection();
			
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO TB_USER (USER_CPF, USER_NAME, USER_EMAIL, USER_PASSWORD, USER_PHONE, USER_TYPE) VALUES (?, ?, ?, ?, ?, ?)");
			stmt.setString(1, customerDTO.getCpf());
			stmt.setString(2, customerDTO.getName());
			stmt.setString(3, customerDTO.getEmail());
			stmt.setString(4, customerDTO.getPassword());
			stmt.setString(5, customerDTO.getPhone());
			stmt.setString(6, customerDTO.getUserType());
			
			int rowsAffected = stmt.executeUpdate();
			
			if(rowsAffected > 0) {
				return true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				super.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return false;
	}
}
