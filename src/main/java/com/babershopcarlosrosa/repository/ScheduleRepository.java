package com.babershopcarlosrosa.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.babershopcarlosrosa.model.dto.ScheduleDTO;
import com.babershopcarlosrosa.model.dto.ScheduledDTO;
import com.babershopcarlosrosa.repository.config.ConnectionRepositoryConfig;

@Repository
public class ScheduleRepository extends ConnectionRepositoryConfig {

	public boolean searchByDateTime(ScheduleDTO schedule) {
		try {

			Connection connection = super.getConnection();

			PreparedStatement stmt = connection
					.prepareStatement("SELECT * FROM tb_scheduling WHERE SKD_DATE = ? AND SKD_TIME = ?");
			stmt.setString(1, schedule.getDate());
			stmt.setString(2, schedule.getTime());

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
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

	public boolean insertScheduling(ScheduleDTO schedule) {
		try {

			Connection connection = super.getConnection();

			PreparedStatement stmt = connection.prepareStatement(
					"INSERT INTO tb_scheduling (BARBER_ID, CUSTOMER_ID, SKD_DATE, SKD_TIME) VALUES (?, ?, ?, ?)");
			stmt.setInt(1, schedule.getBarberId());
			stmt.setInt(2, schedule.getCustomerId());
			stmt.setString(3, schedule.getDate());
			stmt.setString(4, schedule.getTime());

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

	public List<ScheduledDTO> getAllJobsScheduled() {
		List<ScheduledDTO> scheduleds = new ArrayList<>();
		long newId = 0, lastId = 0;
		try {

			Connection connection = super.getConnection();
			
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT ");
			sb.append(" skd.SKD_ID, ");
			sb.append(" skd.SKD_DATE, ");
			sb.append(" skd.SKD_TIME, ");
			sb.append(" us.USER_NAME, ");
			sb.append(" skd.CUSTOMER_ID, ");
			sb.append(" serv.SERVICE_ID, ");
			sb.append(" serv.SERVICE_NAME, ");
			sb.append(" serv.SERVICE_PRICE, ");
			sb.append("FROM tb_scheduling skd ");
			sb.append(" JOIN tb_user us ON skd.CUSTOMER_ID = us.USER_ID ");
			sb.append(" JOIN tb_service serv ON skd.SERVICE_ID = serv.SERVICE_ID ");
			sb.append("WHERE skd.SKD_DATE = ?, skd.SKD_TIME = ?, us.USER_ID = ?");

			PreparedStatement stmt = connection.prepareStatement(sb.toString());

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				newId = rs.getLong("skd.CUSTOMER_ID");
				
				if (newId != lastId) {
					lastId = newId;
					
					
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

		return scheduleds;
	}
}