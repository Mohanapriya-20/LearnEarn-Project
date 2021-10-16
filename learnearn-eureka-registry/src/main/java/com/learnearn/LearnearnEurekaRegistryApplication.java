package com.learnearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class LearnearnEurekaRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnearnEurekaRegistryApplication.class, args);
	}

}
