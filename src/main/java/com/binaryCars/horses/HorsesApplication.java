package com.binaryCars.horses;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class HorsesApplication {
private static final Logger logger =  LoggerFactory.getLogger(HorsesApplication.class);
	public static void main(String[] args) {

		SpringApplication.run(HorsesApplication.class, args);
		logger.info("HorsesApplication started");

	}


}
