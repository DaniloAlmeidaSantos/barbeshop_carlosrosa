package com.babershopcarlosrosa.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.babershopcarlosrosa.model.dto.AuthenticateRequestDTO;

@Repository
public class AuthenticateUserRepository extends ConnectionRepository {
	
	public boolean authenticate(AuthenticateRequestDTO authenticateRequestDTO) {
		
		try {
			Connection connection = super.getConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM TB_USER");
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
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
