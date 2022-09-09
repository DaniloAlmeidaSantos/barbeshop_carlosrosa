package com.babershopcarlosrosa.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class DatabaseConfig {

	@Value("{jdbc.driverClassName}")
	private String driverClassName;

	@Value("{jdbc.url}")
	private String url;

	@Value("{jdbc.username}")
	private String username;

	@Value("{jdbc.password}")
	private String password;

	public DataSource getDataSource() {
		DataSourceBuilder sourceBuilder = DataSourceBuilder.create();
		sourceBuilder.driverClassName(driverClassName);
		sourceBuilder.url(url);
		sourceBuilder.username(username);
		sourceBuilder.password(password);
		return sourceBuilder.build();
	}
}
