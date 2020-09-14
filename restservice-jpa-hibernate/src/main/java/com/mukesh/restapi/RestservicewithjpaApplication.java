package com.mukesh.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class RestservicewithjpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestservicewithjpaApplication.class, args);
	}

}
