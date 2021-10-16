package com.learnearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class LearnearnConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnearnConfigServerApplication.class, args);
	}

}
