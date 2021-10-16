package com.learnearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class LearnearnTrainersRestapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnearnTrainersRestapiApplication.class, args);
	}

}
