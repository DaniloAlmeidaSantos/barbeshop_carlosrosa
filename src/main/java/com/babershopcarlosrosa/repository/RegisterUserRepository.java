package com.babershopcarlosrosa.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.springframework.stereotype.Repository;
import com.babershopcarlosrosa.model.dto.CustomerDTO;

@Repository
public class RegisterUserRepository extends ConnectionRepository{
	
	public boolean register(CustomerDTO customerDTO) {		
		try {
			Connection connection = super.getConnection();
			
			//Revisar o codigo para inserir no banco pois esta diferente da super.UserModel
			
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO TB_USER (USER_CPF, USER_NAME, USER_EMAIL, USER_PASSWORD, USER_PHONE, USER_TYPE) VALUES (?, ?, ?, ?, ?, ?)");		
			int rowsAffected = stmt.executeUpdate();
			
			if(rowsAffected > 0) {
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