package com.example.ApiStarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.example")
@SpringBootApplication
public class TopicsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TopicsApiApplication.class, args);
	}

}
