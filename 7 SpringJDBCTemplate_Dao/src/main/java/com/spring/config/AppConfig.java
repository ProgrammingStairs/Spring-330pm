package com.spring.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("com.spring")
public class AppConfig{
	@Bean
	public DataSource dataSource() {
//		System.out.println("get entry");
		DriverManagerDataSource dmds = new DriverManagerDataSource();
		dmds.setUrl("jdbc:mysql://localhost:3306/spring330");
		dmds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dmds.setUsername("root");
		dmds.setPassword("root");
//		System.out.println("get exit");
		return dmds;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource ds) {
		return new JdbcTemplate(ds);
	}
	
	@Bean
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource ds) {
		return new NamedParameterJdbcTemplate(ds);
	}
}