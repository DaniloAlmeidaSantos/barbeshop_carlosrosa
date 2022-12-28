package com.babershopcarlosrosa.repository.config;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.beans.factory.annotation.Value;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class ConnectionFactory {

	@Value("${barbershop.database.driver}")
	private String driver;

	@Value("${barbershop.database.url}")
	private String url;

	@Value("${barbershop.database.username}")
	private String username;

	@Value("${barbershop.database.password}")
	private String password;

	private static Connection connection = null;

	protected Connection getConnection() {
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, username, password);
			connection.beginRequest();
			return connection;
		} catch (Exception e) {
			log.error("[ DATABASE - ERROR ] Error to create JDBC connection: {} ", e.getMessage());
		}

		return null;
	}

	protected void closeConnection() {
		try {
			connection.endRequest();
			connection.close();
		} catch (Exception e) {
			log.error("[ DATABASE - ERROR ] Error to close JDBC connection: {} ", e.getMessage());
		}
	}

}
