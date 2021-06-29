package com.portfolio.calculateeNetworth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//@EnableEurekaClient
@EnableJpaRepositories("com.portfolio.calculateeNetworth.repository")
@EntityScan("com.portfolio.CalculateeNetworth.model")
public class CalculateeNetworthApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculateeNetworthApplication.class, args);
	}
	 /*@Bean
	 @LoadBalanced
	 public RestTemplate restTemplate() {
	 	return new RestTemplate();
	 	
	 }*/
}
