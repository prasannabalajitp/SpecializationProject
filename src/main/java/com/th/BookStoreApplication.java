package com.th;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * BookStoreApplication class helps in running the application
 * 
 * @author Rohith S
 *
 */
@SpringBootApplication
public class BookStoreApplication extends SpringBootServletInitializer {

	/**
	 * This main method is the starting point of the application
	 * 
	 * @param args Accepts command line input in the form of array
	 */
	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}

}
