package com.cts.retailbank.rules;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class RulesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RulesApplication.class, args);
		log.info("Main Method");
	}

}
