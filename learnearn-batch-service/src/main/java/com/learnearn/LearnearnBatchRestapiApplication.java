package com.learnearn;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.learnearn.model.Batch;
import com.learnearn.model.Course;
import com.learnearn.model.PostPriority;
import com.learnearn.model.PostStatus;
import com.learnearn.service.IBatchService;

@SpringBootApplication
@EnableEurekaClient
public class LearnearnBatchRestapiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LearnearnBatchRestapiApplication.class, args);
	}
	@Bean
	public RestTemplate restTemplate()
	{
		return new RestTemplate();
	}

	@Autowired
	IBatchService batchService;

	@Override
	public void run(String... args) throws Exception {
//		
//		Course course=new Course("Python","Shrika",LocalDateTime.parse("2021-10-07T15:22:56"),LocalDateTime.parse("2021-11-20T15:22:56"),PostStatus.ONHOLD, PostPriority.HIGH);
//		Course course1=new Course("Angular Js","Tharunya",LocalDateTime.parse("2022-03-07T15:22:56"),LocalDateTime.parse("2021-11-20T15:22:56"),PostStatus.ONHOLD, PostPriority.HIGH);
//		List<Course> courseList = Arrays.asList(course,course1);
//		Set<Course> courseSet=new HashSet<>(courseList);
// 		 Batch batch= new Batch("Iconics", "Tom", LocalDateTime.parse("2021-10-07T15:22:56"),LocalDateTime.parse("2022-11-20T15:22:56"),PostStatus.ONHOLD, PostPriority.HIGH,courseSet);
//		 batchService.addBatch(batch);
//		 System.out.println("Value Added");
	}

}
