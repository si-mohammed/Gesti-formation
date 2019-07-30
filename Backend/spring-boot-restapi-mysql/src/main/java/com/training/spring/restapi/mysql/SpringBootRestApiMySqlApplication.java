package com.training.spring.restapi.mysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class SpringBootRestApiMySqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestApiMySqlApplication.class, args);
		
	}
	/*
	 * //Enable Global CORS support for the application
	 * 
	 * @Bean public WebMvcConfigurer corsConfigurer() { return new
	 * WebMvcConfigurerAdapter() {
	 * 
	 * @Override public void addCorsMappings(CorsRegistry registry) {
	 * registry.addMapping("/**") .allowedOrigins("http://localhost:8080")
	 * .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD")
	 * .allowedHeaders("header1", "header2") //What is this for?
	 * .allowCredentials(true); } }; }
	 */
}
