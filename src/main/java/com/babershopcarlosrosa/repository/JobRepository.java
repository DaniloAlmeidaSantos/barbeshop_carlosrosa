package com.babershopcarlosrosa.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.babershopcarlosrosa.model.dto.JobDTO;
import com.babershopcarlosrosa.repository.config.ConnectionFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class JobRepository extends ConnectionFactory {

	public List<JobDTO> getJobs() {
		List<JobDTO> listJobs = new ArrayList<>();
		try {
			Connection connection = super.getConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM tb_service");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				listJobs.add(
						new JobDTO(rs.getInt("SERVICE_ID"), rs.getInt("SERVICE_PRICE"), rs.getString("SERVICE_NAME")));
			}
		} catch (Exception e) {
			log.error("[ OUT - CREATE SERVICE ] Error in get jobs repository: {} ", e);
		} finally {
			try {
				super.closeConnection();
			} catch (SQLException e) {
				log.error("[ OUT - CREATE SERVICE ] Error to close connection in get services repository: {} ", e);
			}
		}
		
		log.info("[ OUT - GET JOBS ] Finshed search jobs: {} ", listJobs.toString());
		return listJobs;
	}

	public boolean updateJob(JobDTO requestJob) {
		try {
			Connection connection = super.getConnection();

			PreparedStatement stmt = connection.prepareStatement(
					"UPDATE tb_service SET SERVICE_NAME = ?, SERVICE_PRICE = ? WHERE SERVICE_ID = jobId");
			stmt.setString(1, requestJob.getJobName());
			stmt.setDouble(2, requestJob.getJobPrice());
			stmt.setLong(3, requestJob.getJobId());

			int rowsAffected = stmt.executeUpdate();

			if (rowsAffected > 0) {
				return true;
			}

		} catch (Exception e) {
			log.error("[ OUT - CREATE SERVICE ] Error in update job repository: {} ", e);
		} finally {
			try {
				super.closeConnection();
			} catch (SQLException e) {
				log.error("[ OUT - CREATE SERVICE ] Error to close connection in update service repository: {} ", e);
			}
		}
		return false;
	}

	public boolean insertJob(JobDTO requestJob) {
		try {
			Connection connection = super.getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("INSERT INTO tb_service (SERVICE_NAME, SERVICE_PRICE) VALUES (?, ?)");
			stmt.setString(1, requestJob.getJobName());
			stmt.setDouble(2, requestJob.getJobPrice());
			int rowsAffected = stmt.executeUpdate();
			if (rowsAffected > 0) {
				log.info("[ OUT - CREATE SERVICE ] Service success created");
				return true;
			}
		} catch (Exception e) {
			log.error("[ OUT - CREATE SERVICE ] Error in create job repository: {} ", e);
		} finally {
			try {
				super.closeConnection();
			} catch (SQLException e) {
				log.error("[ OUT - CREATE SERVICE ] Error to close connection in create service repository: {} ", e);
			}
		}
		return false;
	}
}
