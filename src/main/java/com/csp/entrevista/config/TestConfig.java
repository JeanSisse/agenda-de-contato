package com.csp.entrevista.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.csp.entrevista.services.DBService;

@Configuration
@Profile("test")
public class TestConfig {

	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
	@Autowired
	private DBService dbService;
	
	@Bean
	public boolean instanteateDatabase() {
		
		if(!"create".equals(strategy)) {
			return false;
		}
	
		dbService.instanteateTestDatabase();
		return true;
	}
}
