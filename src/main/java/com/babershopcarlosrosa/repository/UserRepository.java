package com.babershopcarlosrosa.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.babershopcarlosrosa.model.UserModel;
import com.babershopcarlosrosa.model.dto.CustomerDTO;
import com.babershopcarlosrosa.repository.config.ConnectionRepositoryConfig;

@Repository
public class UserRepository extends ConnectionRepositoryConfig {

	public boolean updateUser(UserModel request, int id) {
		try {
			Connection connection = super.getConnection();
			PreparedStatement stmt = connection.prepareStatement(
					"UPDATE tb_user SET USER_PASSWORD = ?, USER_EMAIL = ?, USER_PHONE = ? WHERE USER_ID = ?");
			stmt.setString(1, request.getPassword());
			stmt.setString(2, request.getEmail());
			stmt.setString(3, request.getPhone());
			stmt.setInt(4, id);
			int rows = stmt.executeUpdate(); 
			if (rows > 0) return true;
		} catch (Exception e) {
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
	
	public boolean registerCustomer(CustomerDTO customerDTO) {		
		try {
			Connection connection = super.getConnection();
			
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO tb_user (USER_CPF, USER_NAME, USER_EMAIL, USER_PASSWORD, USER_PHONE, USER_TYPE) VALUES (?, ?, ?, ?, ?, ?)");
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
	
	public boolean registerAdministrator(UserModel userModel) {		
		try {
			Connection connection = super.getConnection();
			
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO tb_user (USER_NAME, USER_EMAIL, USER_PASSWORD, USER_PHONE, USER_TYPE) VALUES (?, ?, ?, ?, ?)");
			stmt.setString(2, userModel.getName());
			stmt.setString(3, userModel.getEmail());
			stmt.setString(4, userModel.getPassword());
			stmt.setString(5, userModel.getPhone());
			stmt.setString(6, userModel.getUserType());
			
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
	
	public boolean isAdministrator(long userId) {
		try {
			Connection connection = super.getConnection();
			
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM tb_user WHERE USER_ID = ? AND USER_TYPE = 'A'");
			stmt.setLong(1, userId);
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
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
