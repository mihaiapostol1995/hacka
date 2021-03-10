package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class RecommendationSystemApp {

	public static void main(String[] args) {
		System.out.println("Starting Recommendation System app");
		SpringApplication.run(RecommendationSystemApp.class, args);
	}

}
