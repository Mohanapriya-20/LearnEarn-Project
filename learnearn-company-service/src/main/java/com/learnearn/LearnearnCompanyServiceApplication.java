package com.learnearn;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.learnearn.model.Company;
import com.learnearn.model.PostPriority;
import com.learnearn.model.PostStatus;
import com.learnearn.service.ICompanyService;

@SpringBootApplication
public class LearnearnCompanyServiceApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(LearnearnCompanyServiceApplication.class, args);
	
		
	}
	@Bean
	public RestTemplate restTemplate()
	{
		return new RestTemplate();
	}
	@Autowired
	ICompanyService companyService;
	
	
	@Override
	public void run(String... args) throws Exception {
		
	}

}
