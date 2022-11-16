package com.babershopcarlosrosa.repository.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class ConnectionRepositoryConfig {
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://barbershopdb.mysql.uhserver.com/barbershopdb";
	private static final String USER = "dbowner";
	private static final String PASSWORD = "Sen@c2022";
	private static Connection connection = null;

	protected Connection getConnection() {
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			return connection;
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

		return null;
	}
	
	protected void closeConnection() throws SQLException {
		if (connection != null) {			
			connection.close();
		}
	}
}
