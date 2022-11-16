package com.babershopcarlosrosa.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.babershopcarlosrosa.model.dto.AuthenticateRequestDTO;
import com.babershopcarlosrosa.model.dto.AuthenticateResponseDTO;
import com.babershopcarlosrosa.repository.config.ConnectionRepositoryConfig;

@Repository
public class AuthenticateUserRepository extends ConnectionRepositoryConfig {

	public AuthenticateResponseDTO authenticate(AuthenticateRequestDTO request) {

		try {
			Connection connection = super.getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("SELECT USER_ID, USER_TYPE FROM tb_user WHERE USER_EMAIL = ? AND USER_PASSWORD = ?");
			stmt.setString(1, request.getEmail());
			stmt.setString(2, request.getPassword());
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				return new AuthenticateResponseDTO(rs.getLong("USER_ID"), rs.getString("USER_TYPE"));
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

		return null;
	}

}
