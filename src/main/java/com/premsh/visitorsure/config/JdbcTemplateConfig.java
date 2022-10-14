package com.premsh.visitorsure.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@Order(2)
public class JdbcTemplateConfig {
	@Autowired
	private DriverManagerDataSource datasource;
	
	@Bean
	public JdbcTemplate jdbcTemplateBean() {
		return  new JdbcTemplate(datasource);
	}
}
