package com.example.sms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/**
 * The main class for the SMS application.
 * This class uses Spring Boot to bootstrap and launch the application.
 */
public class SmsApplication {

	/**
	 * The main method that serves as the entry point for the Spring Boot application.
	 * It calls {@link SpringApplication#run(Class, String...)} to start the application.
	 *
	 * @param args Command line arguments passed to the application.
	 */
	public static void main(String[] args) {
		SpringApplication.run(SmsApplication.class, args);
	}

}
