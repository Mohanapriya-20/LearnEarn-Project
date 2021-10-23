package com.learnearn.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnearn.model.PostAvailability;
import com.learnearn.model.PostStatus;
import com.learnearn.model.Trainer;
import com.learnearn.service.ITrainerService;

@RestController
@RequestMapping("/trainer-service")
public class TrainerController {

	@Autowired
	ITrainerService trainerService;

	@GetMapping("/trainers")
	ResponseEntity<List<Trainer>> getAll() {
		HttpHeaders headers=new HttpHeaders();
		headers.add("desc","Get All Trainers");
		headers.add("info","Returning All Trainers");
		List<Trainer> trainerList=trainerService.getAll();
		return ResponseEntity.ok().headers(headers).body(trainerList);

	}

	@GetMapping("/trainers/trainerId/{trainerId}")
	ResponseEntity<Trainer> getById(@PathVariable("trainerId") int trainerId) {
		HttpHeaders headers=new HttpHeaders();
		headers.add("desc","Get Trainers By Id");
		headers.add("info","Returning Trainers By Id");
		Trainer trainer= trainerService.getById(trainerId);
		return  ResponseEntity.ok().headers(headers).body(trainer);
	}

	@GetMapping("/trainers/availability/{availability}")
	ResponseEntity<List<Trainer>> getByTrainerAvailability(@PathVariable PostAvailability availability) {
		HttpHeaders headers=new HttpHeaders();
		headers.add("desc","Get Trainers By Availability");
		headers.add("info","Returning Trainers By Availability");
		List<Trainer> trainerList= trainerService.getByTrainerAvailability(availability);
		return ResponseEntity.ok().headers(headers).body(trainerList);
	}

	@GetMapping("/trainers/trainerName/{trainerName}")
	ResponseEntity<List<Trainer>> getByTrainerName(@PathVariable String trainerName) {
		HttpHeaders headers=new HttpHeaders();
		headers.add("desc","Get Trainers By trainer name");
		headers.add("info","Returning Trainers By trainer name");
		List<Trainer> trainerList= trainerService.getByTrainerName(trainerName);
		return ResponseEntity.ok().headers(headers).body(trainerList);
	}

	@GetMapping("/trainers/courseName/{courseName}/trainerName/{trainerName}")
	ResponseEntity<List<Trainer>> getByCourseNameAndTrainerName(@PathVariable String courseName,@PathVariable String trainerName) {
		HttpHeaders headers=new HttpHeaders();
		headers.add("desc","Get Trainers By trainer and course name");
		headers.add("info","Returning Trainers By trainer and course name");
		List<Trainer> trainerList= trainerService.getByCourseNameAndTrainerName(courseName, trainerName);
		return ResponseEntity.ok().headers(headers).body(trainerList);
	}

	@GetMapping("/trainers/courseName/{courseName}/availability/{availability}")
	ResponseEntity<List<Trainer>> getByCourseNameAndAvailability(@PathVariable String courseName,@PathVariable PostAvailability availability) {
		HttpHeaders headers=new HttpHeaders();
		headers.add("desc","Get Trainers By availability and course name");
		headers.add("info","Returning Trainers By availability and course name");
		List<Trainer> trainerList=  trainerService.getByCourseNameAndAvailability(courseName, availability);
		return ResponseEntity.ok().headers(headers).body(trainerList);
	}

	@GetMapping("/trainers/courseOwner/{courseOwner}/trainerName/{trainerName}")
	ResponseEntity<List<Trainer>> getByOwnerAndTrainerName(@PathVariable String courseOwner, @PathVariable String trainerName) {
		HttpHeaders headers=new HttpHeaders();
		headers.add("desc","Get Trainers By courseOwner and course name");
		headers.add("info","Returning Trainers By courseOwner and course name");
		List<Trainer> trainerList=  trainerService.getByOwnerAndTrainerName(courseOwner, trainerName);
		return ResponseEntity.ok().headers(headers).body(trainerList);
	}

	@GetMapping("/trainers/courseStartDate/{courseStartDate}/availability/{availability}")
	ResponseEntity<List<Trainer>> getByCourseStartDateAndAvailability(@PathVariable String courseStartDate,
			@PathVariable PostAvailability availability) {
		HttpHeaders headers=new HttpHeaders();
		headers.add("desc","Get Trainers By courseStartDate and availability");
		headers.add("info","Returning Trainers By courseStartDate and availability");
		List<Trainer> trainerList= trainerService.getByCourseStartDateAndAvailability(LocalDateTime.parse(courseStartDate), availability);
		return ResponseEntity.ok().headers(headers).body(trainerList);
	}

	@GetMapping("/trainers/status/{status}/trainerName/{trainerName}")
	ResponseEntity<List<Trainer>> getByCourseStatusAndTrainerName(@PathVariable PostStatus status, @PathVariable String trainerName) {
		HttpHeaders headers=new HttpHeaders();
		headers.add("desc","Get Trainers By status and trainerName");
		headers.add("info","Returning Trainers By status and trainerName");
		List<Trainer> trainerList= trainerService.getByCourseStatusAndTrainerName(status, trainerName);
		return ResponseEntity.ok().headers(headers).body(trainerList);
	}
	
	@GetMapping("/trainers/view-trainers")
	ResponseEntity<List<Trainer>> viewTrainer() {
		HttpHeaders headers=new HttpHeaders();
		headers.add("desc","Get all trainers");
		headers.add("info","Returning all Trainers");
		List<Trainer> trainerList= trainerService.viewTrainer();
		return ResponseEntity.ok().headers(headers).body(trainerList);
	}

	@GetMapping("/trainers/assigntrainer/courseId/{courseId}/trainerId/{trainerId}")
	void assignTrainer(@PathVariable int courseId,@PathVariable int trainerId) {
		HttpHeaders headers=new HttpHeaders();
		headers.add("desc","assign Trainers By courseId");
		headers.add("info","Returning assigned Trainers By courseId");
		 trainerService.assignTrainer(courseId, trainerId);
		 ResponseEntity.ok().headers(headers);
	}
	
	@GetMapping("/trainers/deassigntrainer/trainerId/{trainerId}")
	void deAssignTrainer(@PathVariable int trainerId) {
		HttpHeaders headers=new HttpHeaders();
		headers.add("desc","deassign Trainers By trainerId");
		headers.add("info","Returning deassigned Trainers By trainerId");
		trainerService.deAssignTrainer(trainerId);
		 ResponseEntity.ok().headers(headers);
	}
	

}
