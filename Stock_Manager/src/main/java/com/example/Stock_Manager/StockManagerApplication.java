package com.example.Stock_Manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class StockManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockManagerApplication.class, args);
	}

}
