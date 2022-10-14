package com.premsh.visitorsure.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@Order(1)
public class DriverManagerConfig {
	
	private Logger logger = LoggerFactory.getLogger(DriverManagerConfig.class);
	
	@Value("${database.url}")
	String url;
	@Value("${database.password}")
	String password;
	@Value("${database.username}")
	String username;
	@Value("${database.driver}")
	String driver;
	
	@Bean
	public DriverManagerDataSource driverManagerDataSource() {
		logger.info("Initiating DriverManagerDataSource Bean");
		DriverManagerDataSource dSource = new DriverManagerDataSource(url, username, password); 
		dSource.setDriverClassName(driver);
		return dSource;
	}
}
