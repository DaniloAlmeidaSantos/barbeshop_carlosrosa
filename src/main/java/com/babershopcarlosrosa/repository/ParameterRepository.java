package com.babershopcarlosrosa.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.babershopcarlosrosa.model.dto.ParameterDTO;
import com.babershopcarlosrosa.repository.config.ConnectionRepositoryConfig;

@Repository
public class ParameterRepository extends ConnectionRepositoryConfig{	
	
	public boolean verifyExistParameter(ParameterDTO workParameterDTO) {
		try {
			Connection connection = super.getConnection();

			PreparedStatement stmt = connection.prepareStatement(
					"SELECT COUNT(*) AS COUNT_ROWS FROM TB_PARAMETERS");

			ResultSet resultSet = stmt.executeQuery();
			
			if(resultSet.next()) {
				int count = resultSet.getInt("COUNT_ROWS");			
				if(count > 0) {
					return updateWorkParameter(workParameterDTO);
				}else {
					return insertWorkParameter(workParameterDTO);
				}
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
	
	
	private boolean updateWorkParameter(ParameterDTO workParametersDTO) {
		try {
			Connection connection = super.getConnection();

			PreparedStatement stmt = connection.prepareStatement(
					"UPDATE TB_PARAMETERS SET PARAM_DAYS_WORK = ?, PARAM_WORKLOAD_INIT = ?, PARAM_WORKLOAD_FINISH = ?, PARAM_NAME_PLACE = ?");
			stmt.setString(1, workParametersDTO.getDaysWork());
			stmt.setString(2, workParametersDTO.getHourInitWork());
			stmt.setString(3, workParametersDTO.getHourEndWork());
			stmt.setString(4, workParametersDTO.getNamePlace());

			int rowsAffected = stmt.executeUpdate();
			
			if (rowsAffected > 0) {
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
	
	
	
	private boolean insertWorkParameter(ParameterDTO workParametersDTO) {
		try {
			Connection connection = super.getConnection();

			PreparedStatement stmt = connection.prepareStatement(
					"INSERT INTO TB_PARAMETERS (PARAM_DAYS_WORK, PARAM_WORKLOAD_INIT, PARAM_WORKLOAD_FINISH , PARAM_NAME_PLACE, PARAM_LAST_UPDATED) VALUES (?, ?, ?, ?, NOW())");
			stmt.setString(1, workParametersDTO.getDaysWork());
			stmt.setString(2, workParametersDTO.getHourInitWork());
			stmt.setString(3, workParametersDTO.getHourEndWork());
			stmt.setString(4, workParametersDTO.getNamePlace());

			int rowsAffected = stmt.executeUpdate();
			if (rowsAffected > 0) {
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
