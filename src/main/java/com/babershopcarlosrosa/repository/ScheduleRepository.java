package com.babershopcarlosrosa.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.babershopcarlosrosa.model.dto.ScheduleDTO;

@Repository
public class ScheduleRepository extends ConnectionRepository {
    
    public boolean searchByDateTime(ScheduleDTO schedule) {
        try {
            
            Connection connection = super.getConnection();

            PreparedStatement stmt = connection.prepareStatement(
                sql: "SELECT * FROM TB_SCHEDULING WHERE SKD_DATE = ? AND SKD_TIME = ?");
            stmt.setDate(parameterIndex: 1, schedule.getDate());
            stmt.setDate(parameterIndex: 2, schedule.getTime());

            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
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
                sql: "INSERT INTO TB_SCHEDULING (BARBER_ID, CUSTOMER_ID, SKD_DATE, SKD_TIME) VALUES (?, ?, ?, ?)");
                stmt.setString(parameterIndex: 1, schedule.getBarberId());
                stmt.setString(parameterIndex: 2, schedule.getCustomerId());
                stmt.setString(parameterIndex: 3, schedule.getTime());
                stmt.setString(parameterIndex: 4, schedule.getDate());
                
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
}