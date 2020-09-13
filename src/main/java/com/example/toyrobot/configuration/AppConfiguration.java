package com.example.toyrobot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.toyrobot.model.Report;
import com.example.toyrobot.model.Robot;

@Configuration
public class AppConfiguration {

	@Bean
	public Robot robot() {
		return new Robot();
	}
	
	@Bean
	public Report report() {
		return new Report();
	}
}
