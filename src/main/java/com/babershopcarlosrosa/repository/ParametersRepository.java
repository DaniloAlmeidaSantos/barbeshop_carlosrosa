package com.babershopcarlosrosa.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.babershopcarlosrosa.model.dto.SchedulingDTO;

@Repository
public class ParametersRepository {
    
    public boolean searchByTime(SchedulingDTO schedulingDTO) {
        try {
            Connection connection = super.getConnection();

            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM TB_PARAMETERS WHERE"); // não entendi a idéia
			stmt.setString(0, schedulingDTO.getDaysToWork());
			stmt.setString(1, schedulingDTO.getNamePlace());
			stmt.setString(2, schedulingDTO.getLastUpdate());
			stmt.setString(3, schedulingDTO.getWorkLoadInit());
			stmt.setString(4, schedulingDTO.getWorkLoadFinish());
			
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
