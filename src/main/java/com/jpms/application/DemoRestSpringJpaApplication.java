package com.jpms.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@EnableJpaRepositories(basePackages = "{com.jpms.application.repository}")
@SpringBootApplication
public class DemoRestSpringJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoRestSpringJpaApplication.class, args);
	}

}
