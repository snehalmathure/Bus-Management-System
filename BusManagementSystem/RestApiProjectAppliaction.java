package com.BusManagementSystem;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


/* @SpringBootApplication: A convenience annotation that combines @Configuration
@EnableConfiguration and @ComponentScan. It enables auto-configuration and 
component scanning within the package and its sub-packages.

*/

@SpringBootApplication  

public class RestApiProjectAppliaction {

	public static void main(String[] args) {
		SpringApplication.run(RestApiProjectAppliaction.class, args);
	}

}


