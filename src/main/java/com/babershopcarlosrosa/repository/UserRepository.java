package com.babershopcarlosrosa.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.babershopcarlosrosa.model.dto.CustomerDTO;

@Repository

public class UserRepository extends ConnectionRepository {

	public boolean updateUser(CustomerDTO request, int id) {
		try {
			Connection connection = super.getConnection();
			PreparedStatement stmt = connection.prepareStatement(
					"UPDATE TB_USER SET USER_PASSWORD = ?, USER_EMAIL = ?, USER_PHONE = ? WHERE USER_ID = ?");
			stmt.setString(1, request.getPassword());
			stmt.setString(2, request.getEmail());
			stmt.setString(3,request.getPhone());
			stmt.setInt(4,id);
			int rows = stmt.executeUpdate(); 
			if (rows > 0) return true;
		} catch (Exception e) {
			// TODO: handle exception
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
