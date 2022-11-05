package com.babershopcarlosrosa.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.babershopcarlosrosa.model.dto.JobDTO;
import com.babershopcarlosrosa.repository.config.ConnectionRepositoryConfig;

@Repository
public class JobRepository extends ConnectionRepositoryConfig {
	
	public boolean verifyExistParameter(JobDTO requestJob) {
		try {
			Connection connection = super.getConnection();

			PreparedStatement stmt = connection.prepareStatement("SELECT COUNT(*) AS COUNT_ROWS FROM TB_SERVICE");

			ResultSet resultSet = stmt.executeQuery();

			if (resultSet.next()) {
				int count = resultSet.getInt("COUNT_ROWS");
				if (count > 0) {
					return updateJob(requestJob);
				} else {
					return insertJob(requestJob);
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
	
	public JobDTO getJobs() {
		try {
			Connection connection = super.getConnection();
			PreparedStatement stmt = connection.prepareStatement(
					"SELECT SERVICE_ID, SERVICE_NAME, SERVICE_PRICE");
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				return new JobDTO(
						rs.getInt("SERVICE_ID"), 
						rs.getInt("SERVICE_PRICE"), 
						rs.getString("SERVICE_NAME"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	private boolean updateJob (JobDTO requestJob) {
		try {
			Connection connection = super.getConnection();
			
			PreparedStatement stmt = connection.prepareStatement(
					"UPDATE TB_SERVICE SET SERVICE_NAME = ?, SERVICE_PRICE = ?");
			stmt.setString(1, requestJob.getJobName());
			stmt.setDouble(2, requestJob.getJobPrice());
			
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
	
	private boolean insertJob (JobDTO requestJob) {
		try {
			Connection connection = super.getConnection();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO TB_SERVICE (SERVICE_NAME, SERVICE_PRICE) VALUES (?, ?)");
			stmt.setString(1, requestJob.getJobName());
			stmt.setDouble(2, requestJob.getJobPrice());
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
