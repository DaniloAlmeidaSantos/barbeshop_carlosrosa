package com.babershopcarlosrosa.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.babershopcarlosrosa.model.dto.ScheduleDTO;
import com.babershopcarlosrosa.model.dto.ScheduledDTO;
import com.babershopcarlosrosa.repository.config.ConnectionFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class ScheduleRepository extends ConnectionFactory {

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
			log.error("[ OUT - SCHEDULE ] Error: {} ", e);
			e.printStackTrace();
		} finally {
			super.closeConnection();
		}

		return false;
	}

	public boolean insertScheduling(ScheduleDTO schedule) {
		try {

			Connection connection = super.getConnection();

			PreparedStatement stmt = connection.prepareStatement(
					"INSERT INTO tb_scheduling (BARBER_ID, CUSTOMER_ID, SKD_DATE, SKD_TIME, SERVICE_ID) VALUES (?, ?, ?, ?, ?)");
			stmt.setInt(1, schedule.getBarberId());
			stmt.setInt(2, schedule.getCustomerId());
			stmt.setString(3, schedule.getDate());
			stmt.setString(4, schedule.getTime());
			stmt.setLong(5, Long.parseLong(schedule.getServicesId()));

			int rowsAffected = stmt.executeUpdate();
			if (rowsAffected > 0) {
				return true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			super.closeConnection();
		}

		return false;
	}

	public List<ScheduledDTO> getJobsScheduledToAdmin() {
		List<ScheduledDTO> scheduleds = new ArrayList<>();
		try {
			Connection connection = super.getConnection();

			StringBuilder sb = new StringBuilder();
			sb.append("SELECT ");
			sb.append(" 	GROUP_CONCAT(skd.SKD_ID)  AS INDENTIFICACOES, ");
			sb.append(" 	skd.SKD_DATE AS DATA_AGENDAMENTO, ");
			sb.append(" 	skd.SKD_TIME AS HORARIO_AGENDAMENTO, ");
			sb.append(" 	skd.CUSTOMER_ID AS CLIENTE_ID, ");
			sb.append(" 	GROUP_CONCAT(serv.SERVICE_ID) AS ID_SERVICOS, ");
			sb.append(" 	GROUP_CONCAT(serv.SERVICE_NAME) AS SERVICOS, ");
			sb.append("		skd.SKD_STATUS AS STATUS, ");
			sb.append(" 	SUM(serv.SERVICE_PRICE) AS TOTAL ");
			sb.append("FROM tb_scheduling skd ");
			sb.append(" 	JOIN tb_user us ON skd.CUSTOMER_ID = us.USER_ID ");
			sb.append(" 	JOIN tb_service serv ON skd.SERVICE_ID = serv.SERVICE_ID ");
			sb.append("GROUP BY skd.SKD_DATE, skd.CUSTOMER_ID, skd.SKD_TIME");

			PreparedStatement stmt = connection.prepareStatement(sb.toString());

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				scheduleds.add(new ScheduledDTO(rs.getString("INDENTIFICACOES"), rs.getString("DATA_AGENDAMENTO"),
						rs.getString("HORARIO_AGENDAMENTO"), rs.getString("ID_SERVICOS"), rs.getString("SERVICOS"),
						rs.getString("STATUS"), rs.getDouble("TOTAL")));
			}
		} catch (Exception e) {
			log.error("[ OUT - GET JOBS SCHEDULED ] Error: {} ", e);
			e.printStackTrace();
		} finally {
			super.closeConnection();
		}

		return scheduleds;
	}

	public List<ScheduledDTO> getJobsScheduledToCustomer(long userId) {
		List<ScheduledDTO> scheduleds = new ArrayList<>();
		try {
			Connection connection = super.getConnection();

			StringBuilder sb = new StringBuilder();
			sb.append("SELECT ");
			sb.append(" 	GROUP_CONCAT(skd.SKD_ID)  AS INDENTIFICACOES, ");
			sb.append(" 	skd.SKD_DATE AS DATA_AGENDAMENTO, ");
			sb.append(" 	skd.SKD_TIME AS HORARIO_AGENDAMENTO, ");
			sb.append(" 	skd.CUSTOMER_ID AS CLIENTE_ID, ");
			sb.append(" 	GROUP_CONCAT(serv.SERVICE_ID) AS ID_SERVICOS, ");
			sb.append(" 	GROUP_CONCAT(serv.SERVICE_NAME) AS SERVICOS, ");
			sb.append("		skd.SKD_STATUS AS STATUS, ");
			sb.append(" 	SUM(serv.SERVICE_PRICE) AS TOTAL ");
			sb.append("FROM tb_scheduling skd ");
			sb.append(" 	JOIN tb_user us ON skd.CUSTOMER_ID = us.USER_ID ");
			sb.append(" 	JOIN tb_service serv ON skd.SERVICE_ID = serv.SERVICE_ID ");
			sb.append("WHERE us.USER_ID = ? ");
			sb.append(" 	GROUP BY skd.SKD_DATE, skd.CUSTOMER_ID, skd.SKD_TIME");

			PreparedStatement stmt = connection.prepareStatement(sb.toString());
			stmt.setLong(1, userId);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				scheduleds.add(new ScheduledDTO(rs.getString("INDENTIFICACOES"), rs.getString("DATA_AGENDAMENTO"),
						rs.getString("HORARIO_AGENDAMENTO"), rs.getString("ID_SERVICOS"), rs.getString("SERVICOS"),
						rs.getString("STATUS"), rs.getDouble("TOTAL")));
			}

		} catch (Exception e) {
			log.error("[ OUT - GET JOBS SCHEDULED ] Error: {} ", e);
			e.printStackTrace();
		} finally {
			super.closeConnection();
		}

		return scheduleds;
	}

	public boolean updateStatus(int id) {
		try {
			Connection connection = super.getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("UPDATE tb_scheduling SET SKD_STATUS = 'CANCELADO' WHERE SKD_ID = ?");
			stmt.setInt(1, id);

			int rows = stmt.executeUpdate();

			if (rows > 0)
				return true;
		} catch (Exception e) {
			log.error("[ OUT -  UPDATE STATUS SCHEDULED ] Error in repository: {} ", e);
		} finally {
			super.closeConnection();
		}

		return false;
	}
}