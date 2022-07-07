package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = { "com.example.model" })
@EnableJpaRepositories(basePackages = { "com.example.repository" })
@ComponentScan(basePackages = { "com.example.service", "com.example.controller" })
public class Step13BootBasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(Step13BootBasicApplication.class, args);
	}

}
