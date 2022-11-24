package com.babershopcarlosrosa.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.babershopcarlosrosa.model.dto.ParameterDTO;
import com.babershopcarlosrosa.repository.config.ConnectionFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class ParameterRepository extends ConnectionFactory {

	public boolean verifyExistParameter(ParameterDTO workParameterDTO) {
		try {
			Connection connection = super.getConnection();

			PreparedStatement stmt = connection.prepareStatement("SELECT COUNT(*) AS COUNT_ROWS FROM tb_parameters");

			ResultSet resultSet = stmt.executeQuery();

			if (resultSet.next()) {
				int count = resultSet.getInt("COUNT_ROWS");
				if (count > 0) {
					return updateWorkParameter(workParameterDTO);
				} else {
					return insertWorkParameter(workParameterDTO);
				}
			}

		} catch (Exception e) {
			log.error("[ OUT - CREATE PARAMETERS ] Error to verify exist parameters: {} ", e);
		} finally {
			try {
				super.closeConnection();
			} catch (SQLException e) {
				log.error("[ OUT - CLOSE CONNECTION ERROR ] Error to close connection");
			}
		}
		return false;
	}

	public ParameterDTO getParameters() {
		try {
			Connection connection = super.getConnection();
			PreparedStatement stmt = connection.prepareStatement(
					"SELECT PARAM_DAYS_WORK, PARAM_WORKLOAD_INIT, PARAM_WORKLOAD_FINISH, PARAM_NAME_PLACE FROM tb_parameters");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				return new ParameterDTO(rs.getString("PARAM_DAYS_WORK"), rs.getString("PARAM_WORKLOAD_INIT"),
						rs.getString("PARAM_WORKLOAD_FINISH"), rs.getString("PARAM_NAME_PLACE"));
			}

		} catch (Exception e) {
			log.error("[ OUT - GET PARAMETERS ] Error to get parameters: {} ", e);
		} finally {
			try {
				super.closeConnection();
			} catch (SQLException e) {
				log.error("[ OUT - CLOSE CONNECTION ERROR ] Error to close connection");

			}
		}

		return null;

	}

	private boolean updateWorkParameter(ParameterDTO workParametersDTO) {
		try {
			Connection connection = super.getConnection();

			PreparedStatement stmt = connection.prepareStatement(
					"UPDATE tb_parameters SET PARAM_DAYS_WORK = ?, PARAM_WORKLOAD_INIT = ?, PARAM_WORKLOAD_FINISH = ?, PARAM_NAME_PLACE = ?");
			stmt.setString(1, workParametersDTO.getDaysWork());
			stmt.setString(2, workParametersDTO.getHourInitWork());
			stmt.setString(3, workParametersDTO.getHourEndWork());
			stmt.setString(4, workParametersDTO.getNamePlace());

			int rowsAffected = stmt.executeUpdate();

			if (rowsAffected > 0) {
				return true;
			}
		} catch (Exception e) {
			log.error("[ OUT - CREATE PARAMETERS ] Error to update parameters: {} ", e);
		} finally {
			try {
				super.closeConnection();
			} catch (SQLException e) {
				log.error("[ OUT - CLOSE CONNECTION ERROR ] Error to close connection");
			}
		}

		return false;
	}

	private boolean insertWorkParameter(ParameterDTO workParametersDTO) {
		try {
			Connection connection = super.getConnection();

			PreparedStatement stmt = connection.prepareStatement(
					"INSERT INTO tb_parameters (PARAM_DAYS_WORK, PARAM_WORKLOAD_INIT, PARAM_WORKLOAD_FINISH , PARAM_NAME_PLACE, PARAM_LAST_UPDATED) VALUES (?, ?, ?, ?, NOW())");
			stmt.setString(1, workParametersDTO.getDaysWork());
			stmt.setString(2, workParametersDTO.getHourInitWork());
			stmt.setString(3, workParametersDTO.getHourEndWork());
			stmt.setString(4, workParametersDTO.getNamePlace());

			int rowsAffected = stmt.executeUpdate();
			if (rowsAffected > 0) {
				return true;
			}
		} catch (Exception e) {
			log.error("[ OUT - CREATE PARAMETERS ] Error to create parameters: {} ", e);
		} finally {
			try {
				super.closeConnection();
			} catch (SQLException e) {
				log.error("[ OUT - CLOSE CONNECTION ERROR ] Error to close connection");
			}
		}

		return false;
	}
}
