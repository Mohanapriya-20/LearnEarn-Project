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
		
//		Company  company = new Company("Zoho","Vembu",LocalDateTime.parse("2021-07-07T09:15:00"),LocalDateTime.parse("2021-09-07T17:00:00"),PostStatus.DEFINED,PostPriority.MEDIUM);
//		//Company  company = new Company("Accenture","Kin-hu",LocalDateTime.parse("2020-11-07T10:30:00"),LocalDateTime.parse("2021-03-31T17:00:00"),PostStatus.COMPLETED,PostPriority.LOW);
//
//		companyService.addCompany(company);
		companyService.getAll().forEach(System.out::println);
		//companyService.getByCompanyName("Zoho").forEach(System.out::println);
	}

}
