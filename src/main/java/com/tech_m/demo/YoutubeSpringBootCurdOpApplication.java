package com.tech_m.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.tech_m")
@EnableJpaRepositories(basePackages = "com.tech_m")
@EntityScan(basePackages = "com.tech_m.entity")
public class YoutubeSpringBootCurdOpApplication {

	public static void main(String[] args) {
		SpringApplication.run(YoutubeSpringBootCurdOpApplication.class, args);
		
		System.out.println("program has started");
		
	}

}
