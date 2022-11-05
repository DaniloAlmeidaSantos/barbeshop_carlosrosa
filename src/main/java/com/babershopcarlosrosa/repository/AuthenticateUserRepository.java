package com.babershopcarlosrosa.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.babershopcarlosrosa.model.dto.AuthenticateRequestDTO;

@Repository
public class AuthenticateUserRepository extends ConnectionRepository {

	public boolean authenticate(AuthenticateRequestDTO request) {

		try {
			Connection connection = super.getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("SELECT * FROM TB_USER WHERE USER_EMAIL = ? AND USER_PASSWORD = ?");
			stmt.setString(1, request.getEmail());
			stmt.setString(2, request.getPassword());
			
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
