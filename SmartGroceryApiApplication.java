package com.smart_grocery.smart_grocery_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.smart_grocery.smart_grocery_api")
public class SmartGroceryApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartGroceryApiApplication.class, args);
	}

}
